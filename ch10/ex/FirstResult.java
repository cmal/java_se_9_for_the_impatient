// 29. The method

static CompletableFuture<Object>
    CompletableFuture.anyOf(CompletableFuture<?>... cfs)

// returns as soon as any of the arguments completes, normally or
// exceptionally. This is markedly different from
// ExecutorService.invokeAny which keeps going until one of the tasks
// completes successfully and prevents the method from being used for
// a concurrent search. Implement a method

static CompletableFuture<T> anyOf(List<Supplier<T>> actions, Executor exec)

// that yields the first actual result, or a NoSuchElementException if
// all actions completed with exceptions.
