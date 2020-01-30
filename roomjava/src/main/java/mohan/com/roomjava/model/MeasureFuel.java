package mohan.com.roomjava.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

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
@Entity
public class MeasureFuel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String currentReading;
    private String begunReading;
    private String unitPrice;
    private String filledLitre;
    private String totalCost;
    private String startDate;
    private String endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(String currentReading) {
        this.currentReading = currentReading;
    }

    public String getBegunReading() {
        return begunReading;
    }

    public void setBegunReading(String begunReading) {
        this.begunReading = begunReading;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getFilledLitre() {
        return filledLitre;
    }

    public void setFilledLitre(String filledLitre) {
        this.filledLitre = filledLitre;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
