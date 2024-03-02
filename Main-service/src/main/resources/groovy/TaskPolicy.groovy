package groovy

import com.wht.client.util.StorageUtil

class TaskPolicy {

    def hello() {
        StorageUtil.get()
        return "hello"
    }

}
