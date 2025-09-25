class TravellingSalesMan{
    static int cities; //Number of cities
    static int dist[][]; //distance matrix 
    static int pathParent[][]; //Parent matrix for retracing path
    static int path[]; // actual path with minimum cost
    static int dp[][]; //dp matrix to solve subproblems first
    static final int INF=99999; // INF for high value or infinity

    static int tsp(){
        int allVisited=(1<<cities)-1; // mask for all visited cities
        dp=new int[allVisited+1][cities]; //allocate memory to dp
        pathParent=new int[allVisited+1][cities]; // allocate memory to parent matrix
        path=new int[cities+1]; // allocate memory to path
        for(int mask=0;mask<=allVisited;mask++){
            for(int c=0;c<cities;c++){
                dp[mask][c]=INF; // initialize all dp values to INF
                pathParent[mask][c]=-1; // initialize parents to -1
            }
        }
        dp[1][0]=0; //cost to visit 0 th city is 0 as it is starting point
        int netMask; //To mark next city as visited
        int cost; // to check if the route through current city is optimal or not
        for(int mask=1;mask<=allVisited;mask++){// consider all combinations for travelling
            for(int u=0;u<cities;u++){ // check for all cities
                if((mask & (1<<u)) != 0){ // if u is visited
                    for(int v=0;v<cities;v++){ //serach next city
                        if((mask & (1<<v)) == 0){ // if v is not visited
                            netMask=mask|(1<<v); // mark v as visited
                            cost=dp[mask][u]+dist[u][v]; // calculate cost to go from city u to v 
                            if(cost<dp[netMask][v]){ // check if it is minimum if yes then update dp value and parent matrix
                                dp[netMask][v]=cost;
                                pathParent[netMask][v]=u;
                            }
                        }
                    }
                }
            }
        }
        int minCost=INF; // calculate overall minimum
        int lastCity=-1; // keep track of last city for retracing path
        for(int i=1;i<cities;i++){
            cost=dp[allVisited][i]+dist[i][0]; // consider i as last city and add distance from i to 0 as we need to get back to 0 at the end
            if(cost<minCost){ // if cost is minimum update minimum cost and lastcity 
                minCost=cost;
                lastCity=i;
            }
        }
        path[0]=0; // start is 0
        path[cities]=0; // end is 0 (return to start)
        int temp; // to keep track of lastcity as currMask changes brfore updation of last city
        int currMask=allVisited; // keep track of current mask
        for(int j=cities-1;j>=1;j--){
            path[j]=lastCity; // add last city to path 
            temp=pathParent[currMask][lastCity]; // new last city value
            currMask ^=(1<<lastCity); // remove present last city from mask
            lastCity=temp; // update lastcity value
        }
        return minCost; // return minimum cost
    }
}