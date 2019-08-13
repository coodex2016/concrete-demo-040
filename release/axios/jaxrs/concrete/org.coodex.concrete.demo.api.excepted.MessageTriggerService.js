/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const MessageTriggerService = {
    'trigger': function (x) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedMessageTriggerService/trigger`, 'json', 'POST', x);
    }
}

export default MessageTriggerService


