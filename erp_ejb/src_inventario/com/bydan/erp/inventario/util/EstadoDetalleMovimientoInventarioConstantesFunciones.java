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


import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetalleMovimientoInventarioConstantesFunciones extends EstadoDetalleMovimientoInventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleMovimientoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleMovimientoInventario"+EstadoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleMovimientoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleMovimientoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleMovimientoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleMovimientoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Movimiento Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Movimiento Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Movimiento Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleMovimientoInventario";
	public static final String OBJECTNAME="estadodetallemovimientoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_detalle_movimiento_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetallemovimientoinventario from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" estadodetallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDetalleMovimientoInventarioConstantesFuncionesAdditional estadodetallemovimientoinventarioConstantesFuncionesAdditional=null;
	
	public EstadoDetalleMovimientoInventarioConstantesFuncionesAdditional getEstadoDetalleMovimientoInventarioConstantesFuncionesAdditional() {
		return this.estadodetallemovimientoinventarioConstantesFuncionesAdditional;
	}
	
	public void setEstadoDetalleMovimientoInventarioConstantesFuncionesAdditional(EstadoDetalleMovimientoInventarioConstantesFuncionesAdditional estadodetallemovimientoinventarioConstantesFuncionesAdditional) {
		try {
			this.estadodetallemovimientoinventarioConstantesFuncionesAdditional=estadodetallemovimientoinventarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoDetalleMovimientoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleMovimientoInventarioDescripcion(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetallemovimientoinventario !=null/* && estadodetallemovimientoinventario.getId()!=0*/) {
			sDescripcion=estadodetallemovimientoinventario.getcodigo();//estadodetallemovimientoinventarioestadodetallemovimientoinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleMovimientoInventarioDescripcionDetallado(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleMovimientoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=estadodetallemovimientoinventario.getId().toString()+",";
		sDescripcion+=EstadoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetallemovimientoinventario.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetallemovimientoinventario.getcodigo()+",";
		sDescripcion+=EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetallemovimientoinventario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleMovimientoInventarioDescripcion(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,String sValor) throws Exception {			
		if(estadodetallemovimientoinventario !=null) {
			estadodetallemovimientoinventario.setcodigo(sValor);;//estadodetallemovimientoinventarioestadodetallemovimientoinventario.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetallemovimientoinventario.setcodigo(estadodetallemovimientoinventario.getcodigo().trim());
		estadodetallemovimientoinventario.setnombre(estadodetallemovimientoinventario.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleMovimientoInventarios(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario: estadodetallemovimientoinventarios) {
			estadodetallemovimientoinventario.setcodigo(estadodetallemovimientoinventario.getcodigo().trim());
			estadodetallemovimientoinventario.setnombre(estadodetallemovimientoinventario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetallemovimientoinventario.getConCambioAuxiliar()) {
			estadodetallemovimientoinventario.setIsDeleted(estadodetallemovimientoinventario.getIsDeletedAuxiliar());	
			estadodetallemovimientoinventario.setIsNew(estadodetallemovimientoinventario.getIsNewAuxiliar());	
			estadodetallemovimientoinventario.setIsChanged(estadodetallemovimientoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetallemovimientoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetallemovimientoinventario.setIsDeletedAuxiliar(false);	
			estadodetallemovimientoinventario.setIsNewAuxiliar(false);	
			estadodetallemovimientoinventario.setIsChangedAuxiliar(false);
			
			estadodetallemovimientoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleMovimientoInventarios(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario : estadodetallemovimientoinventarios) {
			if(conAsignarBase && estadodetallemovimientoinventario.getConCambioAuxiliar()) {
				estadodetallemovimientoinventario.setIsDeleted(estadodetallemovimientoinventario.getIsDeletedAuxiliar());	
				estadodetallemovimientoinventario.setIsNew(estadodetallemovimientoinventario.getIsNewAuxiliar());	
				estadodetallemovimientoinventario.setIsChanged(estadodetallemovimientoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetallemovimientoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetallemovimientoinventario.setIsDeletedAuxiliar(false);	
				estadodetallemovimientoinventario.setIsNewAuxiliar(false);	
				estadodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
				estadodetallemovimientoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleMovimientoInventarios(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario: estadodetallemovimientoinventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux) throws Exception  {
		EstadoDetalleMovimientoInventarioConstantesFunciones.InicializarValoresEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarioAux,true);
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario: estadodetallemovimientoinventarios) {
			if(estadodetallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleMovimientoInventarioConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleMovimientoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux: estadodetallemovimientoinventarios) {
			if(estadodetallemovimientoinventarioAux!=null && estadodetallemovimientoinventario!=null) {
				if((estadodetallemovimientoinventarioAux.getId()==null && estadodetallemovimientoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetallemovimientoinventarioAux.getId()!=null && estadodetallemovimientoinventario.getId()!=null){
					if(estadodetallemovimientoinventarioAux.getId().equals(estadodetallemovimientoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario: estadodetallemovimientoinventarios) {			
			if(estadodetallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleMovimientoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_ID, EstadoDetalleMovimientoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO, EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE, EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleMovimientoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleMovimientoInventario() throws Exception  {
		return EstadoDetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarEstadoDetalleMovimientoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleMovimientoInventario(Boolean conFk) throws Exception  {
		return EstadoDetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarEstadoDetalleMovimientoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleMovimientoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleMovimientoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosTemp) throws Exception {
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux:estadodetallemovimientoinventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoDetalleMovimientoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleMovimientoInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleMovimientoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
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
	public static void actualizarLista(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioEncontrado=null;
			
			for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal:estadodetallemovimientoinventarios) {
				if(estadodetallemovimientoinventarioLocal.getId().equals(estadodetallemovimientoinventario.getId())) {
					estadodetallemovimientoinventarioEncontrado=estadodetallemovimientoinventarioLocal;
					
					estadodetallemovimientoinventarioLocal.setIsChanged(estadodetallemovimientoinventario.getIsChanged());
					estadodetallemovimientoinventarioLocal.setIsNew(estadodetallemovimientoinventario.getIsNew());
					estadodetallemovimientoinventarioLocal.setIsDeleted(estadodetallemovimientoinventario.getIsDeleted());
					
					estadodetallemovimientoinventarioLocal.setGeneralEntityOriginal(estadodetallemovimientoinventario.getGeneralEntityOriginal());
					
					estadodetallemovimientoinventarioLocal.setId(estadodetallemovimientoinventario.getId());	
					estadodetallemovimientoinventarioLocal.setVersionRow(estadodetallemovimientoinventario.getVersionRow());	
					estadodetallemovimientoinventarioLocal.setcodigo(estadodetallemovimientoinventario.getcodigo());	
					estadodetallemovimientoinventarioLocal.setnombre(estadodetallemovimientoinventario.getnombre());	
					
					
					estadodetallemovimientoinventarioLocal.setDetalleMovimientoInventarios(estadodetallemovimientoinventario.getDetalleMovimientoInventarios());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetallemovimientoinventario.getIsDeleted()) {
				if(!existe) {
					estadodetallemovimientoinventarios.add(estadodetallemovimientoinventario);
				}
			} else {
				if(estadodetallemovimientoinventarioEncontrado!=null && permiteQuitar)  {
					estadodetallemovimientoinventarios.remove(estadodetallemovimientoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios) throws Exception {
		try	{			
			for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal:estadodetallemovimientoinventarios) {
				if(estadodetallemovimientoinventarioLocal.getId().equals(estadodetallemovimientoinventario.getId())) {
					estadodetallemovimientoinventarioLocal.setIsSelected(estadodetallemovimientoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosAux) throws Exception {
		//this.estadodetallemovimientoinventariosAux=estadodetallemovimientoinventariosAux;
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux:estadodetallemovimientoinventariosAux) {
			if(estadodetallemovimientoinventarioAux.getIsChanged()) {
				estadodetallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(estadodetallemovimientoinventarioAux.getIsNew()) {
				estadodetallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(estadodetallemovimientoinventarioAux.getIsDeleted()) {
				estadodetallemovimientoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux) throws Exception {
		//this.estadodetallemovimientoinventarioAux=estadodetallemovimientoinventarioAux;
		
			if(estadodetallemovimientoinventarioAux.getIsChanged()) {
				estadodetallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(estadodetallemovimientoinventarioAux.getIsNew()) {
				estadodetallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(estadodetallemovimientoinventarioAux.getIsDeleted()) {
				estadodetallemovimientoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAsignar,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) throws Exception {
		estadodetallemovimientoinventarioAsignar.setId(estadodetallemovimientoinventario.getId());	
		estadodetallemovimientoinventarioAsignar.setVersionRow(estadodetallemovimientoinventario.getVersionRow());	
		estadodetallemovimientoinventarioAsignar.setcodigo(estadodetallemovimientoinventario.getcodigo());	
		estadodetallemovimientoinventarioAsignar.setnombre(estadodetallemovimientoinventario.getnombre());	
	}
	
	public static void inicializarEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) throws Exception {
		try {
				estadodetallemovimientoinventario.setId(0L);	
					
				estadodetallemovimientoinventario.setcodigo("");	
				estadodetallemovimientoinventario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallemovimientoinventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallemovimientoinventario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleMovimientoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleMovimientoInventario() {
		return this.sFinalQueryEstadoDetalleMovimientoInventario;
	}
	
	public void setsFinalQueryEstadoDetalleMovimientoInventario(String sFinalQueryEstadoDetalleMovimientoInventario) {
		this.sFinalQueryEstadoDetalleMovimientoInventario= sFinalQueryEstadoDetalleMovimientoInventario;
	}
	
	public Border resaltarSeleccionarEstadoDetalleMovimientoInventario=null;
	
	public Border setResaltarSeleccionarEstadoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleMovimientoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleMovimientoInventario() {
		return this.resaltarSeleccionarEstadoDetalleMovimientoInventario;
	}
	
	public void setResaltarSeleccionarEstadoDetalleMovimientoInventario(Border borderResaltarSeleccionarEstadoDetalleMovimientoInventario) {
		this.resaltarSeleccionarEstadoDetalleMovimientoInventario= borderResaltarSeleccionarEstadoDetalleMovimientoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleMovimientoInventario=null;
	public Boolean mostraridEstadoDetalleMovimientoInventario=true;
	public Boolean activaridEstadoDetalleMovimientoInventario=true;

	public Border resaltarcodigoEstadoDetalleMovimientoInventario=null;
	public Boolean mostrarcodigoEstadoDetalleMovimientoInventario=true;
	public Boolean activarcodigoEstadoDetalleMovimientoInventario=true;

	public Border resaltarnombreEstadoDetalleMovimientoInventario=null;
	public Boolean mostrarnombreEstadoDetalleMovimientoInventario=true;
	public Boolean activarnombreEstadoDetalleMovimientoInventario=true;

	
	

	public Border setResaltaridEstadoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleMovimientoInventario() {
		return this.resaltaridEstadoDetalleMovimientoInventario;
	}

	public void setResaltaridEstadoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltaridEstadoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleMovimientoInventario() {
		return this.mostraridEstadoDetalleMovimientoInventario;
	}

	public void setMostraridEstadoDetalleMovimientoInventario(Boolean mostraridEstadoDetalleMovimientoInventario) {
		this.mostraridEstadoDetalleMovimientoInventario= mostraridEstadoDetalleMovimientoInventario;
	}

	public Boolean getActivaridEstadoDetalleMovimientoInventario() {
		return this.activaridEstadoDetalleMovimientoInventario;
	}

	public void setActivaridEstadoDetalleMovimientoInventario(Boolean activaridEstadoDetalleMovimientoInventario) {
		this.activaridEstadoDetalleMovimientoInventario= activaridEstadoDetalleMovimientoInventario;
	}

	public Border setResaltarcodigoEstadoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleMovimientoInventario() {
		return this.resaltarcodigoEstadoDetalleMovimientoInventario;
	}

	public void setResaltarcodigoEstadoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleMovimientoInventario() {
		return this.mostrarcodigoEstadoDetalleMovimientoInventario;
	}

	public void setMostrarcodigoEstadoDetalleMovimientoInventario(Boolean mostrarcodigoEstadoDetalleMovimientoInventario) {
		this.mostrarcodigoEstadoDetalleMovimientoInventario= mostrarcodigoEstadoDetalleMovimientoInventario;
	}

	public Boolean getActivarcodigoEstadoDetalleMovimientoInventario() {
		return this.activarcodigoEstadoDetalleMovimientoInventario;
	}

	public void setActivarcodigoEstadoDetalleMovimientoInventario(Boolean activarcodigoEstadoDetalleMovimientoInventario) {
		this.activarcodigoEstadoDetalleMovimientoInventario= activarcodigoEstadoDetalleMovimientoInventario;
	}

	public Border setResaltarnombreEstadoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleMovimientoInventario() {
		return this.resaltarnombreEstadoDetalleMovimientoInventario;
	}

	public void setResaltarnombreEstadoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleMovimientoInventario() {
		return this.mostrarnombreEstadoDetalleMovimientoInventario;
	}

	public void setMostrarnombreEstadoDetalleMovimientoInventario(Boolean mostrarnombreEstadoDetalleMovimientoInventario) {
		this.mostrarnombreEstadoDetalleMovimientoInventario= mostrarnombreEstadoDetalleMovimientoInventario;
	}

	public Boolean getActivarnombreEstadoDetalleMovimientoInventario() {
		return this.activarnombreEstadoDetalleMovimientoInventario;
	}

	public void setActivarnombreEstadoDetalleMovimientoInventario(Boolean activarnombreEstadoDetalleMovimientoInventario) {
		this.activarnombreEstadoDetalleMovimientoInventario= activarnombreEstadoDetalleMovimientoInventario;
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
		
		
		this.setMostraridEstadoDetalleMovimientoInventario(esInicial);
		this.setMostrarcodigoEstadoDetalleMovimientoInventario(esInicial);
		this.setMostrarnombreEstadoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleMovimientoInventario(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleMovimientoInventario(esInicial);
		this.setActivarcodigoEstadoDetalleMovimientoInventario(esInicial);
		this.setActivarnombreEstadoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleMovimientoInventario(esInicial);
		this.setResaltarcodigoEstadoDetalleMovimientoInventario(esInicial);
		this.setResaltarnombreEstadoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario=null;

	public Border getResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario() {
		return this.resaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario;
	}

	public void setResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(Border borderResaltarDetalleMovimientoInventario) {
		if(borderResaltarDetalleMovimientoInventario!=null) {
			this.resaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario= borderResaltarDetalleMovimientoInventario;
		}
	}

	public Border setResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMovimientoInventario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleMovimientoInventario.setBorder(borderResaltarDetalleMovimientoInventario);
			
		this.resaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario= borderResaltarDetalleMovimientoInventario;

		 return borderResaltarDetalleMovimientoInventario;
	}



	public Boolean mostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario=true;

	public Boolean getMostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario() {
		return this.mostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario;
	}

	public void setMostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(Boolean visibilidadResaltarDetalleMovimientoInventario) {
		this.mostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario= visibilidadResaltarDetalleMovimientoInventario;
	}



	public Boolean activarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario=true;

	public Boolean gethabilitarResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario() {
		return this.activarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario;
	}

	public void setActivarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(Boolean habilitarResaltarDetalleMovimientoInventario) {
		this.activarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario= habilitarResaltarDetalleMovimientoInventario;
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

		this.setMostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setMostrarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}
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

		this.setActivarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setActivarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleMovimientoInventarioBeanSwingJInternalFrame estadodetallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setResaltarDetalleMovimientoInventarioEstadoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}