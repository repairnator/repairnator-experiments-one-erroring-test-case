/*
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.calc.marketdata;

import java.util.Set;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.data.MarketDataId;
import com.opengamma.strata.data.scenario.MarketDataBox;

/**
 * A market data filter that matches a specific identifier type.
 * 
 * @param <T>  the type of the market data handled by the filter
 */
@BeanDefinition(style = "light", constructorScope = "package")
final class IdTypeFilter<T>
    implements MarketDataFilter<T, MarketDataId<T>>, ImmutableBean {

  /**
   * The type that is matched by this filter.
   */
  @PropertyDefinition(validate = "notNull")
  private final Class<? extends MarketDataId<T>> type;

  //-------------------------------------------------------------------------
  @Override
  public Class<?> getMarketDataIdType() {
    return type;
  }

  @Override
  public boolean matches(MarketDataId<T> marketDataId, MarketDataBox<? extends T> marketData, ReferenceData refData) {
    return true;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IdTypeFilter}.
   */
  private static final MetaBean META_BEAN = LightMetaBean.of(IdTypeFilter.class);

  /**
   * The meta-bean for {@code IdTypeFilter}.
   * @return the meta-bean, not null
   */
  public static MetaBean meta() {
    return META_BEAN;
  }

  static {
    JodaBeanUtils.registerMetaBean(META_BEAN);
  }

  /**
   * Creates an instance.
   * @param type  the value of the property, not null
   */
  IdTypeFilter(
      Class<? extends MarketDataId<T>> type) {
    JodaBeanUtils.notNull(type, "type");
    this.type = type;
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
   * Gets the type that is matched by this filter.
   * @return the value of the property, not null
   */
  public Class<? extends MarketDataId<T>> getType() {
    return type;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IdTypeFilter<?> other = (IdTypeFilter<?>) obj;
      return JodaBeanUtils.equal(type, other.type);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(type);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("IdTypeFilter{");
    buf.append("type").append('=').append(JodaBeanUtils.toString(type));
    buf.append('}');
    return buf.toString();
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
