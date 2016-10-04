library(calibrate)

read.csv('FUN_feasible') ->d
pdf("pareto.pdf")
with(d, {
plot(cost,value,cex=0.1,xlab="Cost (Memory consumption)", ylab="Value (Availability)", main="Optimal Configurations")
symbols(cost, value, circles=constr, inches=1/3, ann=F ,bg="steelblue", fg = par("col"), xlab="Cost (Memory consumption)", ylab="Value (Availability)", main="Optimal Configurations", add=T)
textxy(cost,value,config,cex = 0.75,offset=0)
})
dev.off()

