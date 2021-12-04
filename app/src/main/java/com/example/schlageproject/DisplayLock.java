package com.example.schlageproject;

public class DisplayLock {
    // Trimmed down lock to display names on list, 1 API calls instead of 2.
    // Should be related to Lock class, maybe DisplayLock and ActionableLock inherit from Lock?
    private final String _name;
    private final String _id;

    public DisplayLock(String name, String id) {
        _name = name;
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public String getID() {
        return _id;
    }
}
