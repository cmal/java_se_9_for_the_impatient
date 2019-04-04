// 28. The method
    static CompletableFuture<Void> CompletableFuture.allOf(CompletableFuture<?>... cfs)

// does not yield the results of the arguments, which makes it a bit
// cumbersome to use. Implement a method that combines completable
// futures of the same type:

static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> cfs)

// Note that this method has a List parameter since you cannot
// have variable arguments of a generic type.
