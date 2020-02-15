/*
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.data.scenario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.collect.Messages;
import com.opengamma.strata.collect.timeseries.LocalDateDoubleTimeSeries;
import com.opengamma.strata.data.MarketDataId;
import com.opengamma.strata.data.MarketDataName;
import com.opengamma.strata.data.NamedMarketDataId;
import com.opengamma.strata.data.ObservableId;

/**
 * A set of market data where an item has been added or overridden.
 * <p>
 * This decorates an underlying instance to add or replace a single identifier.
 */
@BeanDefinition(style = "light")
final class ExtendedScenarioMarketData<T>
    implements ScenarioMarketData, ImmutableBean, Serializable {

  /**
   * The additional market data identifier.
   */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataId<T> id;
  /**
   * The additional market data value.
   */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataBox<T> value;
  /**
   * The underlying market data.
   */
  @PropertyDefinition(validate = "notNull")
  private final ScenarioMarketData underlying;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance that decorates the underlying market data.
   * <p>
   * The specified identifier can be queried in the result, returning the specified value.
   * All other identifiers are queried in the underlying market data.
   *
   * @param id  the additional market data identifier
   * @param value  the additional market data value
   * @param underlying  the underlying market data
   * @return a market data instance that decorates the original adding/overriding the specified identifier
   */
  public static <T> ExtendedScenarioMarketData<T> of(
      MarketDataId<T> id,
      MarketDataBox<T> value,
      ScenarioMarketData underlying) {

    return new ExtendedScenarioMarketData<T>(id, value, underlying);
  }

  @ImmutableValidator
  private void validate() {
    if (value.isScenarioValue() && value.getScenarioCount() != underlying.getScenarioCount()) {
      throw new IllegalArgumentException(Messages.format(
          "Scenario count mismatch: value has {} scenarios but this market data has {}",
          value.getScenarioCount(), underlying.getScenarioCount()));
    }
  }

  //-------------------------------------------------------------------------
  @Override
  public MarketDataBox<LocalDate> getValuationDate() {
    return underlying.getValuationDate();
  }

  @Override
  public int getScenarioCount() {
    return underlying.getScenarioCount();
  }

  @Override
  public boolean containsValue(MarketDataId<?> id) {
    if (this.id.equals(id)) {
      return true;
    }
    return underlying.containsValue(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <R> MarketDataBox<R> getValue(MarketDataId<R> id) {
    if (this.id.equals(id)) {
      return (MarketDataBox<R>) value;
    }
    return underlying.getValue(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <R> Optional<MarketDataBox<R>> findValue(MarketDataId<R> id) {
    if (this.id.equals(id)) {
      return Optional.of((MarketDataBox<R>) value);
    }
    return underlying.findValue(id);
  }

  @Override
  public Set<MarketDataId<?>> getIds() {
    return ImmutableSet.<MarketDataId<?>>builder()
        .addAll(underlying.getIds())
        .add(id)
        .build();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <R> Set<MarketDataId<R>> findIds(MarketDataName<R> name) {
    Set<MarketDataId<R>> ids = underlying.findIds(name);
    if (id instanceof NamedMarketDataId) {
      NamedMarketDataId<?> named = (NamedMarketDataId<?>) id;
      if (named.getMarketDataName().equals(name)) {
        return ImmutableSet.<MarketDataId<R>>builder().addAll(ids).add((MarketDataId<R>) id).build();
      }
    }
    return ids;
  }

  @Override
  public Set<ObservableId> getTimeSeriesIds() {
    return underlying.getTimeSeriesIds();
  }

  @Override
  public LocalDateDoubleTimeSeries getTimeSeries(ObservableId id) {
    return underlying.getTimeSeries(id);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ExtendedScenarioMarketData}.
   */
  private static final MetaBean META_BEAN = LightMetaBean.of(ExtendedScenarioMarketData.class);

  /**
   * The meta-bean for {@code ExtendedScenarioMarketData}.
   * @return the meta-bean, not null
   */
  public static MetaBean meta() {
    return META_BEAN;
  }

  static {
    JodaBeanUtils.registerMetaBean(META_BEAN);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private ExtendedScenarioMarketData(
      MarketDataId<T> id,
      MarketDataBox<T> value,
      ScenarioMarketData underlying) {
    JodaBeanUtils.notNull(id, "id");
    JodaBeanUtils.notNull(value, "value");
    JodaBeanUtils.notNull(underlying, "underlying");
    this.id = id;
    this.value = value;
    this.underlying = underlying;
    validate();
  }

  @Override
  public MetaBean metaBean() {
    return META_BEAN;
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
   * Gets the additional market data identifier.
   * @return the value of the property, not null
   */
  public MarketDataId<T> getId() {
    return id;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the additional market data value.
   * @return the value of the property, not null
   */
  public MarketDataBox<T> getValue() {
    return value;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying market data.
   * @return the value of the property, not null
   */
  public ScenarioMarketData getUnderlying() {
    return underlying;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ExtendedScenarioMarketData<?> other = (ExtendedScenarioMarketData<?>) obj;
      return JodaBeanUtils.equal(id, other.id) &&
          JodaBeanUtils.equal(value, other.value) &&
          JodaBeanUtils.equal(underlying, other.underlying);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(id);
    hash = hash * 31 + JodaBeanUtils.hashCode(value);
    hash = hash * 31 + JodaBeanUtils.hashCode(underlying);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("ExtendedScenarioMarketData{");
    buf.append("id").append('=').append(id).append(',').append(' ');
    buf.append("value").append('=').append(value).append(',').append(' ');
    buf.append("underlying").append('=').append(JodaBeanUtils.toString(underlying));
    buf.append('}');
    return buf.toString();
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
