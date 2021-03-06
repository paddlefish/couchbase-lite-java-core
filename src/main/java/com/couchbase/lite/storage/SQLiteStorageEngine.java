/**
 * Created by Wayne Carter.
 * <p/>
 * Copyright (c) 2012 Couchbase, Inc. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.couchbase.lite.storage;

import com.couchbase.lite.database.ContentValues;
import com.couchbase.lite.support.security.SymmetricKey;

public interface SQLiteStorageEngine {
    int CONFLICT_NONE = 0;
    int CONFLICT_IGNORE = 4;
    int CONFLICT_REPLACE = 5;

    boolean open(String path, SymmetricKey encryptionKey) throws SQLException;

    int getVersion();

    void setVersion(int version);

    boolean isOpen();

    void beginTransaction();

    void endTransaction();

    void setTransactionSuccessful();

    void execSQL(String sql) throws SQLException;

    void execSQL(String sql, Object[] bindArgs) throws SQLException;

    Cursor rawQuery(String sql, String[] selectionArgs);

    long insert(String table, String nullColumnHack, ContentValues values);

    long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException;

    long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm);

    int update(String table, ContentValues values, String whereClause, String[] whereArgs);

    int delete(String table, String whereClause, String[] whereArgs);

    void close();

    boolean supportEncryption();

    byte[] derivePBKDF2SHA256Key(String password, byte[] salt, int rounds);
}
