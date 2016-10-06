library(calibrate)

read.csv('FUN_feasible') ->d
pdf("pareto.pdf")
#par(mar = c(2, 2, 1, 1))
with(d, {
plot(cost,value,cex.main=1.5,cex.lab=1.5,cex.axis=1.5,xlab="Cost (Memory consumption in MB)", ylab="Value (Availability)", main="Optimal Configurations",xlim=c(50, 100), ylim=c(0.45, 0.7))
symbols(cost, value, circles=constr, inches=1/3, ann=F ,bg="lightgrey", fg = par("col"), xlab="Cost (Memory consumption)", ylab="Value (Availability)", main="Optimal Configurations", add=T)
textxy(cost,value,config,cex = 1,offset=0,cex.axis=1.95)
})
dev.off()

