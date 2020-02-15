/*
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.basics.date;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.direct.DirectPrivateBeanBuilder;

/**
 * A holiday calendar implementation that only has holidays at weekends.
 * <p>
 * This immutable implementation of {@link HolidayCalendar} determines whether
 * a date is a business day or holiday solely by the day of week.
 * This supports three special cases for Sat/Sun, Fri/Sat and Thu/Fri.
 * Other combinations can be setup using {@link ImmutableHolidayCalendar}.
 */
@BeanDefinition(builderScope = "private")
final class WeekendHolidayCalendar
    implements HolidayCalendar, ImmutableBean, Serializable {
  // methods are overridden from default implementations to gain performance

  /**
   * The singleton instance of the 'Sat/Sun' calendar.
   */
  static final WeekendHolidayCalendar SAT_SUN = new WeekendHolidayCalendar(HolidayCalendarIds.SAT_SUN, SATURDAY, SUNDAY);
  /**
   * The singleton instance of the 'Fri/Sat' calendar.
   */
  static final WeekendHolidayCalendar FRI_SAT = new WeekendHolidayCalendar(HolidayCalendarIds.FRI_SAT, FRIDAY, SATURDAY);
  /**
   * The singleton instance of the 'Thu/Fri' calendar.
   */
  static final WeekendHolidayCalendar THU_FRI = new WeekendHolidayCalendar(HolidayCalendarIds.THU_FRI, THURSDAY, FRIDAY);

  /**
   * The identifier.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final HolidayCalendarId id;
  /**
   * The first weekend day.
   */
  @PropertyDefinition(validate = "notNull")
  private final DayOfWeek day1;
  /**
   * The second weekend day.
   */
  @PropertyDefinition(validate = "notNull")
  private final DayOfWeek day2;

  // resolve after deserialization
  private Object readResolve() throws InvalidObjectException {
    if (id == HolidayCalendarIds.SAT_SUN) {
      return SAT_SUN;
    }
    if (id == HolidayCalendarIds.FRI_SAT) {
      return FRI_SAT;
    }
    if (id == HolidayCalendarIds.THU_FRI) {
      return THU_FRI;
    }
    throw new InvalidObjectException("Invalid WeekendHolidayCalendar identifier");
  }

  //-------------------------------------------------------------------------
  @Override
  public boolean isHoliday(LocalDate date) {
    DayOfWeek dow = date.getDayOfWeek();
    return dow == day1 || dow == day2;
  }

  @Override
  public LocalDate shift(LocalDate date, int amount) {
    // optimize because we know there are 5 business days in a week
    LocalDate weekAdjusted = date.plusWeeks(amount / 5);
    return HolidayCalendar.super.shift(weekAdjusted, amount % 5);
  }

  //-------------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof WeekendHolidayCalendar) {
      return id.equals(((WeekendHolidayCalendar) obj).id);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "HolidayCalendar[" + id.getName() + ']';
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code WeekendHolidayCalendar}.
   * @return the meta-bean, not null
   */
  public static WeekendHolidayCalendar.Meta meta() {
    return WeekendHolidayCalendar.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(WeekendHolidayCalendar.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private WeekendHolidayCalendar(
      HolidayCalendarId id,
      DayOfWeek day1,
      DayOfWeek day2) {
    JodaBeanUtils.notNull(id, "id");
    JodaBeanUtils.notNull(day1, "day1");
    JodaBeanUtils.notNull(day2, "day2");
    this.id = id;
    this.day1 = day1;
    this.day2 = day2;
  }

  @Override
  public WeekendHolidayCalendar.Meta metaBean() {
    return WeekendHolidayCalendar.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the identifier.
   * @return the value of the property, not null
   */
  @Override
  public HolidayCalendarId getId() {
    return id;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the first weekend day.
   * @return the value of the property, not null
   */
  public DayOfWeek getDay1() {
    return day1;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the second weekend day.
   * @return the value of the property, not null
   */
  public DayOfWeek getDay2() {
    return day2;
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code WeekendHolidayCalendar}.
   */
  static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code id} property.
     */
    private final MetaProperty<HolidayCalendarId> id = DirectMetaProperty.ofImmutable(
        this, "id", WeekendHolidayCalendar.class, HolidayCalendarId.class);
    /**
     * The meta-property for the {@code day1} property.
     */
    private final MetaProperty<DayOfWeek> day1 = DirectMetaProperty.ofImmutable(
        this, "day1", WeekendHolidayCalendar.class, DayOfWeek.class);
    /**
     * The meta-property for the {@code day2} property.
     */
    private final MetaProperty<DayOfWeek> day2 = DirectMetaProperty.ofImmutable(
        this, "day2", WeekendHolidayCalendar.class, DayOfWeek.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "id",
        "day1",
        "day2");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3355:  // id
          return id;
        case 3076117:  // day1
          return day1;
        case 3076118:  // day2
          return day2;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends WeekendHolidayCalendar> builder() {
      return new WeekendHolidayCalendar.Builder();
    }

    @Override
    public Class<? extends WeekendHolidayCalendar> beanType() {
      return WeekendHolidayCalendar.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code id} property.
     * @return the meta-property, not null
     */
    public MetaProperty<HolidayCalendarId> id() {
      return id;
    }

    /**
     * The meta-property for the {@code day1} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayOfWeek> day1() {
      return day1;
    }

    /**
     * The meta-property for the {@code day2} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayOfWeek> day2() {
      return day2;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3355:  // id
          return ((WeekendHolidayCalendar) bean).getId();
        case 3076117:  // day1
          return ((WeekendHolidayCalendar) bean).getDay1();
        case 3076118:  // day2
          return ((WeekendHolidayCalendar) bean).getDay2();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code WeekendHolidayCalendar}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<WeekendHolidayCalendar> {

    private HolidayCalendarId id;
    private DayOfWeek day1;
    private DayOfWeek day2;

    /**
     * Restricted constructor.
     */
    private Builder() {
      super(meta());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3355:  // id
          return id;
        case 3076117:  // day1
          return day1;
        case 3076118:  // day2
          return day2;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3355:  // id
          this.id = (HolidayCalendarId) newValue;
          break;
        case 3076117:  // day1
          this.day1 = (DayOfWeek) newValue;
          break;
        case 3076118:  // day2
          this.day2 = (DayOfWeek) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public WeekendHolidayCalendar build() {
      return new WeekendHolidayCalendar(
          id,
          day1,
          day2);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("WeekendHolidayCalendar.Builder{");
      buf.append("id").append('=').append(JodaBeanUtils.toString(id)).append(',').append(' ');
      buf.append("day1").append('=').append(JodaBeanUtils.toString(day1)).append(',').append(' ');
      buf.append("day2").append('=').append(JodaBeanUtils.toString(day2));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
