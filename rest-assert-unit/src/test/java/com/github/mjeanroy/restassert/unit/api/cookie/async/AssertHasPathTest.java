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

package com.github.mjeanroy.restassert.unit.api.cookie.async;

import com.github.mjeanroy.restassert.tests.builders.ning.NingHttpCookieBuilder;
import com.ning.http.client.cookie.Cookie;

import static com.github.mjeanroy.restassert.unit.api.cookie.NingHttpCookieAssert.assertHasPath;

public class AssertHasPathTest extends AbstractNingHttpCookieTest {

	@Override
	protected void invoke(Cookie actual) {
		assertHasPath(actual, success().getPath());
	}

	@Override
	protected void invoke(String message, Cookie actual) {
		assertHasPath(message, actual, success().getPath());
	}

	@Override
	protected Cookie success() {
		return cookie("foo");
	}

	@Override
	protected Cookie failure() {
		final String expectedPath = success().getPath();
		final String actualPath = expectedPath + "foo";
		return cookie(actualPath);
	}

	@Override
	protected String pattern() {
		return "Expecting cookie to have path %s but was %s";
	}

	@Override
	protected Object[] placeholders() {
		final String expectedPath = success().getPath();
		final String actualPath = failure().getPath();
		return new Object[]{
				expectedPath, actualPath
		};
	}

	private Cookie cookie(String path) {
		return new NingHttpCookieBuilder()
				.setPath(path)
				.build();
	}
}
