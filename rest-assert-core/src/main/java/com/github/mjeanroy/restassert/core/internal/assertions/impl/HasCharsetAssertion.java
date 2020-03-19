/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2018 Mickael Jeanroy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mjeanroy.restassert.core.internal.assertions.impl;

import com.github.mjeanroy.restassert.core.data.ContentType;
import com.github.mjeanroy.restassert.core.internal.assertions.AssertionResult;
import com.github.mjeanroy.restassert.core.internal.data.HttpHeader;
import com.github.mjeanroy.restassert.core.internal.loggers.Logger;
import com.github.mjeanroy.restassert.core.internal.loggers.Loggers;

import java.util.List;

import static com.github.mjeanroy.restassert.core.internal.assertions.AssertionResult.failure;
import static com.github.mjeanroy.restassert.core.internal.assertions.AssertionResult.success;
import static com.github.mjeanroy.restassert.core.internal.common.PreConditions.notBlank;
import static com.github.mjeanroy.restassert.core.internal.error.http.ShouldHaveCharset.shouldHaveCharset;

/**
 * Check that http response has a content-type header with
 * expected charset.
 */
public class HasCharsetAssertion extends AbstractHeaderEqualToAssertion implements HttpResponseAssertion {

	/**
	 * Class logger.
	 */
	private static final Logger log = Loggers.getLogger(HasCharsetAssertion.class);

	/**
	 * Expected charset.
	 */
	private final String expectedCharset;

	/**
	 * Create assertion.
	 *
	 * @param expectedCharset Charset name.
	 */
	public HasCharsetAssertion(String expectedCharset) {
		super(HttpHeader.CONTENT_TYPE.getName());
		this.expectedCharset = notBlank(expectedCharset, "Charset value must be defined");
	}

	@Override
	AssertionResult doAssertion(List<String> values) {
		String rawValue = values.get(0);
		log.debug("Extracting expectedCharset from: {}", rawValue);

		ContentType contentType = ContentType.parser().parse(rawValue);
		String actualCharset = contentType.getCharset();

		if (actualCharset == null) {
			log.debug("Charset value is not specified, fail");
			return failure(shouldHaveCharset());
		}

		log.debug("Comparing expectedCharset '{}' with '{}'", actualCharset, expectedCharset);
		return actualCharset.equalsIgnoreCase(expectedCharset) ? success() : getFailure(actualCharset);
	}

	private AssertionResult getFailure(String actualCharset) {
		return failure(shouldHaveCharset(expectedCharset, actualCharset));
	}
}
