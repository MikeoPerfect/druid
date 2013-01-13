/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.filter.wall;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.wall.WallUtils;

/**
 * SQLServerWallTest
 * 
 * @author RaymondXiu
 * @version 1.0, 2012-3-18
 * @see
 */
public class MySqlWallTest1 extends TestCase {

    /**
     * @param name
     */
    public MySqlWallTest1(String name){
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test_stuff() throws Exception {
        Assert.assertTrue(WallUtils.isValidateMySql(//
        "select count(*) from (select DATE_FORMAT(staydate,'%m月') as month,sum(a) as addnum,sum(q) as quitnum from (select staydate,1 as a,0 as q from add_person union all select quitdate,0 as a,1 as q from quit_person) t where  (DATE_FORMAT(staydate,'%Y')= ? )  group by DATE_FORMAT(staydate,'%Y-%m'))"));
    }
}