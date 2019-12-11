#include <bits/stdc++.h>


using namespace std;


int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        int matrix[n][m],a[n][m],a1[n][m],b[n][m],co=0,mn=INT_MAX;
        for(int i=0;i<n;i++)
        	for(int j=0;j<m;j++)
        		matrix[i][j]=co++;
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
        cin>>a1[i][j];
        }
        vector<pair<int,pair<int,int>>> vector_p,vp1;
        vector<pair<int,int>> out,main_out;
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
            cin>>b[i][j];
         
         }
         int vg=366;
         for(int hj=0;hj<2;hj++,vg++)
         {
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
        a[i][j]=a1[i][j];
        }
         for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
            int cd=0;
            for(int i1=max(i-b[i][j],0);i1<=min(n-1,i+b[i][j]);i1++)
            cd+=a[i1][j];
            for(int j1=max(j-b[i][j],0);j1<=min(m-1,j+b[i][j]);j1++)
            cd+=a[i][j1];
            cd-=a[i][j];
            vector_p.push_back(make_pair(cd,make_pair(i,j)));
        }
        sort(vector_p.begin(),vector_p.end());
        for(int f=0;f<=4;f++)
        {
        for(int i=vector_p.size()-1;i>=0;i--)
        {
            int x=vector_p[i].second.first,y=vector_p[i].second.second,cd=0;
            
            for(int i1=max(x-b[x][y],0);i1<=min(n-1,x+b[x][y]);i1++)
            cd+=a[i1][y];
            for(int j1=max(y-b[x][y],0);j1<=min(m-1,y+b[x][y]);j1++)
            cd+=a[x][j1];
            cd-=a[x][y];
            
            if(cd>((vector_p[i].first*vg)/1000))
            {
                out.push_back(make_pair(x,y));
                for(int i1=max(x-b[x][y],0);i1<=min(n-1,x+b[x][y]);i1++)
                a[i1][y]=0;
                for(int j1=max(y-b[x][y],0);j1<=min(m-1,y+b[x][y]);j1++)
                a[x][j1]=0;
            }
        }
        vector_p.clear();
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
            int cd=0;
            for(int i1=max(i-b[i][j],0);i1<=min(n-1,i+b[i][j]);i1++)
            cd+=a[i1][j];
            for(int j1=max(j-b[i][j],0);j1<=min(m-1,j+b[i][j]);j1++)
            cd+=a[i][j1];
            cd-=a[i][j];
            vector_p.push_back(make_pair(cd,make_pair(i,j)));
        }
        sort(vector_p.begin(),vector_p.end());
    }
        for(int i=vector_p.size()-1;i>=0;i--)
        {
            int x=vector_p[i].second.first,y=vector_p[i].second.second,cd=0;
            
            for(int i1=max(x-b[x][y],0);i1<=min(n-1,x+b[x][y]);i1++)
            cd+=a[i1][y];
            for(int j1=max(y-b[x][y],0);j1<=min(m-1,y+b[x][y]);j1++)
            cd+=a[x][j1];
            cd-=a[x][y];
            
            if(cd>0)
            {
                out.push_back(make_pair(x,y));
                for(int i1=max(x-b[x][y],0);i1<=min(n-1,x+b[x][y]);i1++)
                a[i1][y]=0;
                for(int j1=max(y-b[x][y],0);j1<=min(m-1,y+b[x][y]);j1++)
                a[x][j1]=0;
            }
        }
        if(out.size()<mn)
        {
            main_out=out;
            mn=out.size();
        }
         }
        cout<<main_out.size()<<endl;
        for(int i=0;i<main_out.size();i++)
        cout<<main_out[i].first<<" "<<main_out[i].second<<endl;
    }
    return 0;
}