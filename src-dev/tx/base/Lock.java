/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tx.base;


/** An instance of a lock */
public class Lock
{
    /** UNLOCKED :  No locks outstanding.
     *  SHARED :    Read only.
     *  RESERVED :  Read-only : write notification of intent.  Only one writer can hold this. Coexists with SHARED; new SHARED locsk issued.
     *  PENDING :   Writer waiting to get an exclusive lock.  No more readers.
     *  EXCLUSIVE : Single writer, no readers
     */

    public static enum LockState { UNLOCKED, SHARED, RESERVED, PENDING, EXCLUSIVE }

    private final LockState state ;
    
    // Create a lock via the LockManager.
    /*package*/ Lock(LockState state)
    {
        this.state = state ; 
    }
    
    public LockState getState() { return state ; }
    
    // What it locks.
}
