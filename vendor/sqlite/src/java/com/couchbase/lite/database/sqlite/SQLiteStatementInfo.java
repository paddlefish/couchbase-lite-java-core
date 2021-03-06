/**
 * Modified by Pasin Suriyentrakorn on 9/21/15.
 * Source: https://github.com/android/platform_frameworks_base/tree/24ff6823c411f794aceaae89b0b029fbf8ef6b29
 *
 * Copyright (c) 2015 Couchbase, Inc.
 *
 * Copyright (C) 2011 The Android Open Source Project
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

package com.couchbase.lite.database.sqlite;

/**
 * Describes a SQLite statement.
 *
 * @hide
 */
public final class SQLiteStatementInfo {
    /**
     * The number of parameters that the statement has.
     */
    public int numParameters;

    /**
     * The names of all columns in the result set of the statement.
     */
    public String[] columnNames;

    /**
     * True if the statement is read-only.
     */
    public boolean readOnly;
}
