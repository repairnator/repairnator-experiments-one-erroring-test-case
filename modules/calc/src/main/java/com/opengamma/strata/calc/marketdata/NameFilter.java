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
import com.opengamma.strata.data.MarketDataName;
import com.opengamma.strata.data.NamedMarketDataId;
import com.opengamma.strata.data.scenario.MarketDataBox;

/**
 * A market data filter that matches a specific name.
 * 
 * @param <T>  the type of the market data handled by the filter
 */
@BeanDefinition(style = "light", constructorScope = "package")
final class NameFilter<T, I extends T>
    implements MarketDataFilter<T, NamedMarketDataId<I>>, ImmutableBean {

  /**
   * The name that is matched by this filter.
   */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataName<I> name;

  //-------------------------------------------------------------------------
  @Override
  public Class<?> getMarketDataIdType() {
    return NamedMarketDataId.class;
  }

  @Override
  public boolean matches(NamedMarketDataId<I> marketDataId, MarketDataBox<? extends T> marketData, ReferenceData refData) {
    return marketDataId.getMarketDataName().equals(name);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code NameFilter}.
   */
  private static final MetaBean META_BEAN = LightMetaBean.of(NameFilter.class);

  /**
   * The meta-bean for {@code NameFilter}.
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
   * @param name  the value of the property, not null
   */
  NameFilter(
      MarketDataName<I> name) {
    JodaBeanUtils.notNull(name, "name");
    this.name = name;
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
   * Gets the name that is matched by this filter.
   * @return the value of the property, not null
   */
  public MarketDataName<I> getName() {
    return name;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      NameFilter<?, ?> other = (NameFilter<?, ?>) obj;
      return JodaBeanUtils.equal(name, other.name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(name);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("NameFilter{");
    buf.append("name").append('=').append(JodaBeanUtils.toString(name));
    buf.append('}');
    return buf.toString();
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
