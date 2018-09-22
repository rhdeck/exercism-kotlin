fun <T> List<T>.relationshipTo(otherList: List<T>) = when {
    (this == otherList) -> Relationship.EQUAL
    (0..this.size - otherList.size).fold(false) { isOK, pos -> isOK || (this.subList(pos, pos + otherList.size) == otherList)} -> Relationship.SUPERLIST
    (0..otherList.size - this.size).fold(false) { isOK, pos -> isOK || (otherList.subList(pos, pos + this.size) == this)} -> Relationship.SUBLIST
    else -> Relationship.UNEQUAL
}