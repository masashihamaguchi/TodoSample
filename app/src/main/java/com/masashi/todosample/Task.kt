package com.masashi.todosample

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by Masashi Hamaguchi on 2022/01/29.
 */

open class Task(
    @PrimaryKey
    open var id: String = UUID.randomUUID().toString(),
    open var title: String = "",
    open var memo: String = ""
) : RealmObject()