/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.message.boards.ratings.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.ratings.test.util.BaseRatingsTestCase;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class MBCategoryRatingsTest extends BaseRatingsTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected BaseModel<?> addBaseModel(
			BaseModel<?> parentBaseModel, ServiceContext serviceContext)
		throws Exception {

		return MBCategoryLocalServiceUtil.addCategory(
			TestPropsValues.getUserId(),
			MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
			RandomTestUtil.randomString(), StringPool.BLANK, serviceContext);
	}

	@Override
	protected BaseModel<?> deleteBaseModel(
			BaseModel<?> baseModel, ServiceContext serviceContext)
		throws Exception {

		MBCategoryLocalServiceUtil.deleteCategory((MBCategory)baseModel);

		return null;
	}

	@Override
	protected Class<?> getBaseModelClass() {
		return MBCategory.class;
	}

}