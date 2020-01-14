package com.johnfneto.rocketlaunchfeed

import java.util.ArrayList
import java.util.HashMap

object MockData{

    /**
     * An array of sample (mock) items.
     */
    val ITEMS: MutableList<MockItem> = ArrayList()

    /**
     * A map of sample (mock) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, MockItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: MockItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): MockItem {
        return MockItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class MockItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}