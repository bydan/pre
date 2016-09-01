/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.inventario.util.PrioridadPedidoConstantesFunciones;
import com.bydan.erp.inventario.util.PrioridadPedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PrioridadPedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PrioridadPedidoConstantesFunciones extends PrioridadPedidoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PrioridadPedido";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PrioridadPedido"+PrioridadPedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PrioridadPedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PrioridadPedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PrioridadPedidoConstantesFunciones.SCHEMA+"_"+PrioridadPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PrioridadPedidoConstantesFunciones.SCHEMA+"_"+PrioridadPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PrioridadPedidoConstantesFunciones.SCHEMA+"_"+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PrioridadPedidoConstantesFunciones.SCHEMA+"_"+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PrioridadPedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PrioridadPedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PrioridadPedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PrioridadPedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Prioridad Pedidoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Prioridad Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Prioridad Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PrioridadPedido";
	public static final String OBJECTNAME="prioridadpedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="prioridad_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select prioridadpedido from "+PrioridadPedidoConstantesFunciones.SPERSISTENCENAME+" prioridadpedido";
	public static String QUERYSELECTNATIVE="select "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".id,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".id_empresa,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".nombre,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".dia from "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+PrioridadPedidoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PrioridadPedidoConstantesFuncionesAdditional prioridadpedidoConstantesFuncionesAdditional=null;
	
	public PrioridadPedidoConstantesFuncionesAdditional getPrioridadPedidoConstantesFuncionesAdditional() {
		return this.prioridadpedidoConstantesFuncionesAdditional;
	}
	
	public void setPrioridadPedidoConstantesFuncionesAdditional(PrioridadPedidoConstantesFuncionesAdditional prioridadpedidoConstantesFuncionesAdditional) {
		try {
			this.prioridadpedidoConstantesFuncionesAdditional=prioridadpedidoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DIA= "dia";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIA= "Dia";
		public static final String LABEL_DIA_LOWER= "Dia";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPrioridadPedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PrioridadPedidoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PrioridadPedidoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PrioridadPedidoConstantesFunciones.NOMBRE)) {sLabelColumna=PrioridadPedidoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PrioridadPedidoConstantesFunciones.DIA)) {sLabelColumna=PrioridadPedidoConstantesFunciones.LABEL_DIA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
	
	public static String getPrioridadPedidoDescripcion(PrioridadPedido prioridadpedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(prioridadpedido !=null/* && prioridadpedido.getId()!=0*/) {
			sDescripcion=prioridadpedido.getnombre();//prioridadpedidoprioridadpedido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPrioridadPedidoDescripcionDetallado(PrioridadPedido prioridadpedido) {
		String sDescripcion="";
			
		sDescripcion+=PrioridadPedidoConstantesFunciones.ID+"=";
		sDescripcion+=prioridadpedido.getId().toString()+",";
		sDescripcion+=PrioridadPedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=prioridadpedido.getVersionRow().toString()+",";
		sDescripcion+=PrioridadPedidoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=prioridadpedido.getid_empresa().toString()+",";
		sDescripcion+=PrioridadPedidoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=prioridadpedido.getnombre()+",";
		sDescripcion+=PrioridadPedidoConstantesFunciones.DIA+"=";
		sDescripcion+=prioridadpedido.getdia().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPrioridadPedidoDescripcion(PrioridadPedido prioridadpedido,String sValor) throws Exception {			
		if(prioridadpedido !=null) {
			prioridadpedido.setnombre(sValor);//prioridadpedidoprioridadpedido.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPrioridadPedido(PrioridadPedido prioridadpedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		prioridadpedido.setnombre(prioridadpedido.getnombre().trim());
	}
	
	public static void quitarEspaciosPrioridadPedidos(List<PrioridadPedido> prioridadpedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PrioridadPedido prioridadpedido: prioridadpedidos) {
			prioridadpedido.setnombre(prioridadpedido.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrioridadPedido(PrioridadPedido prioridadpedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && prioridadpedido.getConCambioAuxiliar()) {
			prioridadpedido.setIsDeleted(prioridadpedido.getIsDeletedAuxiliar());	
			prioridadpedido.setIsNew(prioridadpedido.getIsNewAuxiliar());	
			prioridadpedido.setIsChanged(prioridadpedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			prioridadpedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			prioridadpedido.setIsDeletedAuxiliar(false);	
			prioridadpedido.setIsNewAuxiliar(false);	
			prioridadpedido.setIsChangedAuxiliar(false);
			
			prioridadpedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrioridadPedidos(List<PrioridadPedido> prioridadpedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PrioridadPedido prioridadpedido : prioridadpedidos) {
			if(conAsignarBase && prioridadpedido.getConCambioAuxiliar()) {
				prioridadpedido.setIsDeleted(prioridadpedido.getIsDeletedAuxiliar());	
				prioridadpedido.setIsNew(prioridadpedido.getIsNewAuxiliar());	
				prioridadpedido.setIsChanged(prioridadpedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				prioridadpedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				prioridadpedido.setIsDeletedAuxiliar(false);	
				prioridadpedido.setIsNewAuxiliar(false);	
				prioridadpedido.setIsChangedAuxiliar(false);
				
				prioridadpedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPrioridadPedido(PrioridadPedido prioridadpedido,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			prioridadpedido.setdia(0);
		}
	}		
	
	public static void InicializarValoresPrioridadPedidos(List<PrioridadPedido> prioridadpedidos,Boolean conEnteros) throws Exception  {
		
		for(PrioridadPedido prioridadpedido: prioridadpedidos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				prioridadpedido.setdia(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPrioridadPedido(List<PrioridadPedido> prioridadpedidos,PrioridadPedido prioridadpedidoAux) throws Exception  {
		PrioridadPedidoConstantesFunciones.InicializarValoresPrioridadPedido(prioridadpedidoAux,true);
		
		for(PrioridadPedido prioridadpedido: prioridadpedidos) {
			if(prioridadpedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			prioridadpedidoAux.setdia(prioridadpedidoAux.getdia()+prioridadpedido.getdia());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PrioridadPedidoConstantesFunciones.getArrayColumnasGlobalesPrioridadPedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PrioridadPedidoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PrioridadPedidoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PrioridadPedido> prioridadpedidos,PrioridadPedido prioridadpedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PrioridadPedido prioridadpedidoAux: prioridadpedidos) {
			if(prioridadpedidoAux!=null && prioridadpedido!=null) {
				if((prioridadpedidoAux.getId()==null && prioridadpedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(prioridadpedidoAux.getId()!=null && prioridadpedido.getId()!=null){
					if(prioridadpedidoAux.getId().equals(prioridadpedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPrioridadPedido(List<PrioridadPedido> prioridadpedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PrioridadPedido prioridadpedido: prioridadpedidos) {			
			if(prioridadpedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPrioridadPedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PrioridadPedidoConstantesFunciones.LABEL_ID, PrioridadPedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrioridadPedidoConstantesFunciones.LABEL_VERSIONROW, PrioridadPedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrioridadPedidoConstantesFunciones.LABEL_IDEMPRESA, PrioridadPedidoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrioridadPedidoConstantesFunciones.LABEL_NOMBRE, PrioridadPedidoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrioridadPedidoConstantesFunciones.LABEL_DIA, PrioridadPedidoConstantesFunciones.DIA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPrioridadPedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PrioridadPedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrioridadPedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrioridadPedidoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrioridadPedidoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrioridadPedidoConstantesFunciones.DIA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrioridadPedido() throws Exception  {
		return PrioridadPedidoConstantesFunciones.getTiposSeleccionarPrioridadPedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrioridadPedido(Boolean conFk) throws Exception  {
		return PrioridadPedidoConstantesFunciones.getTiposSeleccionarPrioridadPedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrioridadPedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrioridadPedidoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PrioridadPedidoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrioridadPedidoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PrioridadPedidoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrioridadPedidoConstantesFunciones.LABEL_DIA);
			reporte.setsDescripcion(PrioridadPedidoConstantesFunciones.LABEL_DIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPrioridadPedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPrioridadPedido(PrioridadPedido prioridadpedidoAux) throws Exception {
		
			prioridadpedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prioridadpedidoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPrioridadPedido(List<PrioridadPedido> prioridadpedidosTemp) throws Exception {
		for(PrioridadPedido prioridadpedidoAux:prioridadpedidosTemp) {
			
			prioridadpedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prioridadpedidoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrioridadPedidoConstantesFunciones.getClassesRelationshipsOfPrioridadPedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCompra.class)) {
						classes.add(new Classe(ParametroCompra.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrioridadPedidoConstantesFunciones.getClassesRelationshipsFromStringsOfPrioridadPedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PrioridadPedido prioridadpedido,List<PrioridadPedido> prioridadpedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PrioridadPedido prioridadpedidoEncontrado=null;
			
			for(PrioridadPedido prioridadpedidoLocal:prioridadpedidos) {
				if(prioridadpedidoLocal.getId().equals(prioridadpedido.getId())) {
					prioridadpedidoEncontrado=prioridadpedidoLocal;
					
					prioridadpedidoLocal.setIsChanged(prioridadpedido.getIsChanged());
					prioridadpedidoLocal.setIsNew(prioridadpedido.getIsNew());
					prioridadpedidoLocal.setIsDeleted(prioridadpedido.getIsDeleted());
					
					prioridadpedidoLocal.setGeneralEntityOriginal(prioridadpedido.getGeneralEntityOriginal());
					
					prioridadpedidoLocal.setId(prioridadpedido.getId());	
					prioridadpedidoLocal.setVersionRow(prioridadpedido.getVersionRow());	
					prioridadpedidoLocal.setid_empresa(prioridadpedido.getid_empresa());	
					prioridadpedidoLocal.setnombre(prioridadpedido.getnombre());	
					prioridadpedidoLocal.setdia(prioridadpedido.getdia());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!prioridadpedido.getIsDeleted()) {
				if(!existe) {
					prioridadpedidos.add(prioridadpedido);
				}
			} else {
				if(prioridadpedidoEncontrado!=null && permiteQuitar)  {
					prioridadpedidos.remove(prioridadpedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PrioridadPedido prioridadpedido,List<PrioridadPedido> prioridadpedidos) throws Exception {
		try	{			
			for(PrioridadPedido prioridadpedidoLocal:prioridadpedidos) {
				if(prioridadpedidoLocal.getId().equals(prioridadpedido.getId())) {
					prioridadpedidoLocal.setIsSelected(prioridadpedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPrioridadPedido(List<PrioridadPedido> prioridadpedidosAux) throws Exception {
		//this.prioridadpedidosAux=prioridadpedidosAux;
		
		for(PrioridadPedido prioridadpedidoAux:prioridadpedidosAux) {
			if(prioridadpedidoAux.getIsChanged()) {
				prioridadpedidoAux.setIsChanged(false);
			}		
			
			if(prioridadpedidoAux.getIsNew()) {
				prioridadpedidoAux.setIsNew(false);
			}	
			
			if(prioridadpedidoAux.getIsDeleted()) {
				prioridadpedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPrioridadPedido(PrioridadPedido prioridadpedidoAux) throws Exception {
		//this.prioridadpedidoAux=prioridadpedidoAux;
		
			if(prioridadpedidoAux.getIsChanged()) {
				prioridadpedidoAux.setIsChanged(false);
			}		
			
			if(prioridadpedidoAux.getIsNew()) {
				prioridadpedidoAux.setIsNew(false);
			}	
			
			if(prioridadpedidoAux.getIsDeleted()) {
				prioridadpedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PrioridadPedido prioridadpedidoAsignar,PrioridadPedido prioridadpedido) throws Exception {
		prioridadpedidoAsignar.setId(prioridadpedido.getId());	
		prioridadpedidoAsignar.setVersionRow(prioridadpedido.getVersionRow());	
		prioridadpedidoAsignar.setid_empresa(prioridadpedido.getid_empresa());
		prioridadpedidoAsignar.setempresa_descripcion(prioridadpedido.getempresa_descripcion());	
		prioridadpedidoAsignar.setnombre(prioridadpedido.getnombre());	
		prioridadpedidoAsignar.setdia(prioridadpedido.getdia());	
	}
	
	public static void inicializarPrioridadPedido(PrioridadPedido prioridadpedido) throws Exception {
		try {
				prioridadpedido.setId(0L);	
					
				prioridadpedido.setid_empresa(-1L);	
				prioridadpedido.setnombre("");	
				prioridadpedido.setdia(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPrioridadPedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PrioridadPedidoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrioridadPedidoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrioridadPedidoConstantesFunciones.LABEL_DIA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPrioridadPedido(String sTipo,Row row,Workbook workbook,PrioridadPedido prioridadpedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(prioridadpedido.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prioridadpedido.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prioridadpedido.getdia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPrioridadPedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPrioridadPedido() {
		return this.sFinalQueryPrioridadPedido;
	}
	
	public void setsFinalQueryPrioridadPedido(String sFinalQueryPrioridadPedido) {
		this.sFinalQueryPrioridadPedido= sFinalQueryPrioridadPedido;
	}
	
	public Border resaltarSeleccionarPrioridadPedido=null;
	
	public Border setResaltarSeleccionarPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//prioridadpedidoBeanSwingJInternalFrame.jTtoolBarPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPrioridadPedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPrioridadPedido() {
		return this.resaltarSeleccionarPrioridadPedido;
	}
	
	public void setResaltarSeleccionarPrioridadPedido(Border borderResaltarSeleccionarPrioridadPedido) {
		this.resaltarSeleccionarPrioridadPedido= borderResaltarSeleccionarPrioridadPedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPrioridadPedido=null;
	public Boolean mostraridPrioridadPedido=true;
	public Boolean activaridPrioridadPedido=true;

	public Border resaltarid_empresaPrioridadPedido=null;
	public Boolean mostrarid_empresaPrioridadPedido=true;
	public Boolean activarid_empresaPrioridadPedido=true;
	public Boolean cargarid_empresaPrioridadPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPrioridadPedido=false;//ConEventDepend=true

	public Border resaltarnombrePrioridadPedido=null;
	public Boolean mostrarnombrePrioridadPedido=true;
	public Boolean activarnombrePrioridadPedido=true;

	public Border resaltardiaPrioridadPedido=null;
	public Boolean mostrardiaPrioridadPedido=true;
	public Boolean activardiaPrioridadPedido=true;

	
	

	public Border setResaltaridPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prioridadpedidoBeanSwingJInternalFrame.jTtoolBarPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltaridPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPrioridadPedido() {
		return this.resaltaridPrioridadPedido;
	}

	public void setResaltaridPrioridadPedido(Border borderResaltar) {
		this.resaltaridPrioridadPedido= borderResaltar;
	}

	public Boolean getMostraridPrioridadPedido() {
		return this.mostraridPrioridadPedido;
	}

	public void setMostraridPrioridadPedido(Boolean mostraridPrioridadPedido) {
		this.mostraridPrioridadPedido= mostraridPrioridadPedido;
	}

	public Boolean getActivaridPrioridadPedido() {
		return this.activaridPrioridadPedido;
	}

	public void setActivaridPrioridadPedido(Boolean activaridPrioridadPedido) {
		this.activaridPrioridadPedido= activaridPrioridadPedido;
	}

	public Border setResaltarid_empresaPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prioridadpedidoBeanSwingJInternalFrame.jTtoolBarPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarid_empresaPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPrioridadPedido() {
		return this.resaltarid_empresaPrioridadPedido;
	}

	public void setResaltarid_empresaPrioridadPedido(Border borderResaltar) {
		this.resaltarid_empresaPrioridadPedido= borderResaltar;
	}

	public Boolean getMostrarid_empresaPrioridadPedido() {
		return this.mostrarid_empresaPrioridadPedido;
	}

	public void setMostrarid_empresaPrioridadPedido(Boolean mostrarid_empresaPrioridadPedido) {
		this.mostrarid_empresaPrioridadPedido= mostrarid_empresaPrioridadPedido;
	}

	public Boolean getActivarid_empresaPrioridadPedido() {
		return this.activarid_empresaPrioridadPedido;
	}

	public void setActivarid_empresaPrioridadPedido(Boolean activarid_empresaPrioridadPedido) {
		this.activarid_empresaPrioridadPedido= activarid_empresaPrioridadPedido;
	}

	public Boolean getCargarid_empresaPrioridadPedido() {
		return this.cargarid_empresaPrioridadPedido;
	}

	public void setCargarid_empresaPrioridadPedido(Boolean cargarid_empresaPrioridadPedido) {
		this.cargarid_empresaPrioridadPedido= cargarid_empresaPrioridadPedido;
	}

	public Border setResaltarnombrePrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prioridadpedidoBeanSwingJInternalFrame.jTtoolBarPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarnombrePrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePrioridadPedido() {
		return this.resaltarnombrePrioridadPedido;
	}

	public void setResaltarnombrePrioridadPedido(Border borderResaltar) {
		this.resaltarnombrePrioridadPedido= borderResaltar;
	}

	public Boolean getMostrarnombrePrioridadPedido() {
		return this.mostrarnombrePrioridadPedido;
	}

	public void setMostrarnombrePrioridadPedido(Boolean mostrarnombrePrioridadPedido) {
		this.mostrarnombrePrioridadPedido= mostrarnombrePrioridadPedido;
	}

	public Boolean getActivarnombrePrioridadPedido() {
		return this.activarnombrePrioridadPedido;
	}

	public void setActivarnombrePrioridadPedido(Boolean activarnombrePrioridadPedido) {
		this.activarnombrePrioridadPedido= activarnombrePrioridadPedido;
	}

	public Border setResaltardiaPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prioridadpedidoBeanSwingJInternalFrame.jTtoolBarPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltardiaPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiaPrioridadPedido() {
		return this.resaltardiaPrioridadPedido;
	}

	public void setResaltardiaPrioridadPedido(Border borderResaltar) {
		this.resaltardiaPrioridadPedido= borderResaltar;
	}

	public Boolean getMostrardiaPrioridadPedido() {
		return this.mostrardiaPrioridadPedido;
	}

	public void setMostrardiaPrioridadPedido(Boolean mostrardiaPrioridadPedido) {
		this.mostrardiaPrioridadPedido= mostrardiaPrioridadPedido;
	}

	public Boolean getActivardiaPrioridadPedido() {
		return this.activardiaPrioridadPedido;
	}

	public void setActivardiaPrioridadPedido(Boolean activardiaPrioridadPedido) {
		this.activardiaPrioridadPedido= activardiaPrioridadPedido;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridPrioridadPedido(esInicial);
		this.setMostrarid_empresaPrioridadPedido(esInicial);
		this.setMostrarnombrePrioridadPedido(esInicial);
		this.setMostrardiaPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.ID)) {
				this.setMostraridPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.DIA)) {
				this.setMostrardiaPrioridadPedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridPrioridadPedido(esInicial);
		this.setActivarid_empresaPrioridadPedido(esInicial);
		this.setActivarnombrePrioridadPedido(esInicial);
		this.setActivardiaPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.ID)) {
				this.setActivaridPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.DIA)) {
				this.setActivardiaPrioridadPedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPrioridadPedido(esInicial);
		this.setResaltarid_empresaPrioridadPedido(esInicial);
		this.setResaltarnombrePrioridadPedido(esInicial);
		this.setResaltardiaPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.ID)) {
				this.setResaltaridPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrioridadPedidoConstantesFunciones.DIA)) {
				this.setResaltardiaPrioridadPedido(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombrePrioridadPedido=true;

	public Boolean getMostrarBusquedaPorNombrePrioridadPedido() {
		return this.mostrarBusquedaPorNombrePrioridadPedido;
	}

	public void setMostrarBusquedaPorNombrePrioridadPedido(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePrioridadPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPrioridadPedido=true;

	public Boolean getMostrarFK_IdEmpresaPrioridadPedido() {
		return this.mostrarFK_IdEmpresaPrioridadPedido;
	}

	public void setMostrarFK_IdEmpresaPrioridadPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPrioridadPedido= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombrePrioridadPedido=true;

	public Boolean getActivarBusquedaPorNombrePrioridadPedido() {
		return this.activarBusquedaPorNombrePrioridadPedido;
	}

	public void setActivarBusquedaPorNombrePrioridadPedido(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePrioridadPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPrioridadPedido=true;

	public Boolean getActivarFK_IdEmpresaPrioridadPedido() {
		return this.activarFK_IdEmpresaPrioridadPedido;
	}

	public void setActivarFK_IdEmpresaPrioridadPedido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPrioridadPedido= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombrePrioridadPedido=null;

	public Border getResaltarBusquedaPorNombrePrioridadPedido() {
		return this.resaltarBusquedaPorNombrePrioridadPedido;
	}

	public void setResaltarBusquedaPorNombrePrioridadPedido(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePrioridadPedido= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePrioridadPedido= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPrioridadPedido=null;

	public Border getResaltarFK_IdEmpresaPrioridadPedido() {
		return this.resaltarFK_IdEmpresaPrioridadPedido;
	}

	public void setResaltarFK_IdEmpresaPrioridadPedido(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPrioridadPedido= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*PrioridadPedidoBeanSwingJInternalFrame prioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPrioridadPedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}