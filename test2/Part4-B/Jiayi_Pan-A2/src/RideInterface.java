public interface RideInterface {
    /**
     * 将游客添加到队列中
     *
     * @param visitor
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * 从队列中移除游客
     *
     * @param visitor
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * 打印队列中的游客
     */
    void printQueue();

    /**
     * 执行游乐设施的一次循环
     */
    void runOneCycle();

    /**
     * 将游客添加到历史记录中
     *
     * @param visitor
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * 检查游客是否在历史记录中
     *
     * @param visitor
     * @return
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * 返回历史记录中的游客数量
     *
     * @return
     */
    int numberOfVisitors();

    /**
     * 打印游乐设施历史记录中的游客
     */
    void printRideHistory();
}
