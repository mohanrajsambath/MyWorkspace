package mohan.com.roomjava.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import mohan.com.roomjava.dao.DaoAccess;
import mohan.com.roomjava.model.MeasureFuel;

/*
 * Copyright (c) 2019. Created by Mohanraj.S,Innobot Systems on 13/7/19 for MyWorkspace
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Database(entities = {MeasureFuel.class}, version = 1, exportSchema = false)
public abstract class FuelDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
