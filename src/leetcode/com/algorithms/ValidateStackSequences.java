class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int posU=0, posO =0;
        while(posU < pushed.length){
            if(!st.isEmpty() && popped[posO] == st.peek()){
                st.pop();
                posO++;
            }else if(pushed[posU] == popped[posO]){
                posU++;
                posO++;
            }else{
                st.push(pushed[posU++]);
            }
        }
        while(posO<popped.length){
            if(popped[posO]!=st.peek()){
                return false;
            }
            st.pop();
            posO++;
        }
        return true;
    }
}