package mohan.com.experimentation;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Copyright (c) 2019. Created by Mohanraj.S,Innobot Systems on 5/4/19 for MyWorkspace
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
public class AddElement {
    public static void main(String[] args) {

        // Create a LinkedList
        LinkedList<String> linkedlist = new LinkedList<String>();

        // Add elements to LinkedList
        linkedlist.add("Delhi");
        linkedlist.add("Agra");
        linkedlist.add("Mysore");
        linkedlist.add("Chennai");
        linkedlist.add("Pune");

        // Adding new Element at 5th Position
        linkedlist.add(4, "NEW ELEMENT");

        // Iterating the list in forward direction
        System.out.println("LinkedList elements After Addition:");
        Iterator it= linkedlist.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
