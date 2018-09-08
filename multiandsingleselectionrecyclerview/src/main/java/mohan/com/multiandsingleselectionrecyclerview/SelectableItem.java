package mohan.com.multiandsingleselectionrecyclerview;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 3/9/18 for MyWorkspace
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
public class SelectableItem extends Item{
    private boolean isSelected = false;


    public SelectableItem(Item item,boolean isSelected) {
        super(item.getName(),item.getSurname());
        this.isSelected = isSelected;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}