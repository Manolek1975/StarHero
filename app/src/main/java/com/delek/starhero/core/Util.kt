package com.delek.starhero.core

import java.lang.reflect.Field

class Util {

    companion object {
        fun getResId(resName: String?, c: Class<*>): Int {
            try {
                val idField: Field = c.getDeclaredField(resName!!)
                return idField.getInt(idField)
            } catch (e: Exception) {
                e.printStackTrace()
                return -1
            }
        }
    }

}