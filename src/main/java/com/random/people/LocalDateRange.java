package com.random.people;

import java.time.LocalDate;

/**
 * This class represents a closed range (interval) of LocalDates.
 *
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class LocalDateRange {
    private final LocalDate start;
    private final LocalDate end;

    public LocalDateRange(final LocalDate start, final LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException(
                    String.format(
                            "end date must be later than start date, yet values are: start=%s, end=%s",
                            start.toString(), end.toString()
                    )
            );
        }
        this.start = start;
        this.end = end;
    }

    public boolean contains(final LocalDate candidate) {
        return candidate.isEqual(this.start)
                || candidate.isEqual(this.end)
                || (candidate.isAfter(this.start) && candidate.isBefore(this.end));
    }

    public boolean includes(final LocalDateRange other) {
        return contains(other.start) && contains(other.end);
    }

    public boolean overlaps(final LocalDateRange other) {
        return other.contains(this.start) || other.contains(this.end) || includes(other);
    }

    @Override
    public String toString() {
        return "LocalDateRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
