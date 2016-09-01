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


import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetalleAutoriConsepConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleAutoriConsep";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleAutoriConsep"+EstadoDetalleAutoriConsepConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleAutoriConsepHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleAutoriConsepHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleAutoriConsepConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleAutoriConsepConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Autorizacion Consepes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Detalle Autorizacion Consep";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Autori Consep";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleAutoriConsep";
	public static final String OBJECTNAME="estadodetalleautoriconsep";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_detalle_autori_consep";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetalleautoriconsep from "+EstadoDetalleAutoriConsepConstantesFunciones.SPERSISTENCENAME+" estadodetalleautoriconsep";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
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
	
	public static String getEstadoDetalleAutoriConsepLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleAutoriConsepConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleAutoriConsepConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleAutoriConsepDescripcion(EstadoDetalleAutoriConsep estadodetalleautoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetalleautoriconsep !=null/* && estadodetalleautoriconsep.getId()!=0*/) {
			sDescripcion=estadodetalleautoriconsep.getcodigo();//estadodetalleautoriconsepestadodetalleautoriconsep.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleAutoriConsepDescripcionDetallado(EstadoDetalleAutoriConsep estadodetalleautoriconsep) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleAutoriConsepConstantesFunciones.ID+"=";
		sDescripcion+=estadodetalleautoriconsep.getId().toString()+",";
		sDescripcion+=EstadoDetalleAutoriConsepConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetalleautoriconsep.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleAutoriConsepConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetalleautoriconsep.getcodigo()+",";
		sDescripcion+=EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetalleautoriconsep.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleAutoriConsepDescripcion(EstadoDetalleAutoriConsep estadodetalleautoriconsep,String sValor) throws Exception {			
		if(estadodetalleautoriconsep !=null) {
			estadodetalleautoriconsep.setcodigo(sValor);;//estadodetalleautoriconsepestadodetalleautoriconsep.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetalleautoriconsep.setcodigo(estadodetalleautoriconsep.getcodigo().trim());
		estadodetalleautoriconsep.setnombre(estadodetalleautoriconsep.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep: estadodetalleautoriconseps) {
			estadodetalleautoriconsep.setcodigo(estadodetalleautoriconsep.getcodigo().trim());
			estadodetalleautoriconsep.setnombre(estadodetalleautoriconsep.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetalleautoriconsep.getConCambioAuxiliar()) {
			estadodetalleautoriconsep.setIsDeleted(estadodetalleautoriconsep.getIsDeletedAuxiliar());	
			estadodetalleautoriconsep.setIsNew(estadodetalleautoriconsep.getIsNewAuxiliar());	
			estadodetalleautoriconsep.setIsChanged(estadodetalleautoriconsep.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetalleautoriconsep.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetalleautoriconsep.setIsDeletedAuxiliar(false);	
			estadodetalleautoriconsep.setIsNewAuxiliar(false);	
			estadodetalleautoriconsep.setIsChangedAuxiliar(false);
			
			estadodetalleautoriconsep.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep : estadodetalleautoriconseps) {
			if(conAsignarBase && estadodetalleautoriconsep.getConCambioAuxiliar()) {
				estadodetalleautoriconsep.setIsDeleted(estadodetalleautoriconsep.getIsDeletedAuxiliar());	
				estadodetalleautoriconsep.setIsNew(estadodetalleautoriconsep.getIsNewAuxiliar());	
				estadodetalleautoriconsep.setIsChanged(estadodetalleautoriconsep.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetalleautoriconsep.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetalleautoriconsep.setIsDeletedAuxiliar(false);	
				estadodetalleautoriconsep.setIsNewAuxiliar(false);	
				estadodetalleautoriconsep.setIsChangedAuxiliar(false);
				
				estadodetalleautoriconsep.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep: estadodetalleautoriconseps) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsep estadodetalleautoriconsepAux) throws Exception  {
		EstadoDetalleAutoriConsepConstantesFunciones.InicializarValoresEstadoDetalleAutoriConsep(estadodetalleautoriconsepAux,true);
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep: estadodetalleautoriconseps) {
			if(estadodetalleautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleAutoriConsepConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleAutoriConsep(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,EstadoDetalleAutoriConsep estadodetalleautoriconsep,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux: estadodetalleautoriconseps) {
			if(estadodetalleautoriconsepAux!=null && estadodetalleautoriconsep!=null) {
				if((estadodetalleautoriconsepAux.getId()==null && estadodetalleautoriconsep.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetalleautoriconsepAux.getId()!=null && estadodetalleautoriconsep.getId()!=null){
					if(estadodetalleautoriconsepAux.getId().equals(estadodetalleautoriconsep.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep: estadodetalleautoriconseps) {			
			if(estadodetalleautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleAutoriConsep() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleAutoriConsepConstantesFunciones.LABEL_ID, EstadoDetalleAutoriConsepConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleAutoriConsepConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleAutoriConsepConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleAutoriConsepConstantesFunciones.LABEL_CODIGO, EstadoDetalleAutoriConsepConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE, EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleAutoriConsep() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleAutoriConsepConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleAutoriConsepConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleAutoriConsepConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleAutoriConsep() throws Exception  {
		return EstadoDetalleAutoriConsepConstantesFunciones.getTiposSeleccionarEstadoDetalleAutoriConsep(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleAutoriConsep(Boolean conFk) throws Exception  {
		return EstadoDetalleAutoriConsepConstantesFunciones.getTiposSeleccionarEstadoDetalleAutoriConsep(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleAutoriConsep(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleAutoriConsep(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsTemp) throws Exception {
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux:estadodetalleautoriconsepsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleAutoriConsepConstantesFunciones.getClassesRelationshipsOfEstadoDetalleAutoriConsep(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleAutoriConsep.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAutoriConsep.class)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleAutoriConsepConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleAutoriConsep(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); continue;
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
	public static void actualizarLista(EstadoDetalleAutoriConsep estadodetalleautoriconsep,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleAutoriConsep estadodetalleautoriconsepEncontrado=null;
			
			for(EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal:estadodetalleautoriconseps) {
				if(estadodetalleautoriconsepLocal.getId().equals(estadodetalleautoriconsep.getId())) {
					estadodetalleautoriconsepEncontrado=estadodetalleautoriconsepLocal;
					
					estadodetalleautoriconsepLocal.setIsChanged(estadodetalleautoriconsep.getIsChanged());
					estadodetalleautoriconsepLocal.setIsNew(estadodetalleautoriconsep.getIsNew());
					estadodetalleautoriconsepLocal.setIsDeleted(estadodetalleautoriconsep.getIsDeleted());
					
					estadodetalleautoriconsepLocal.setGeneralEntityOriginal(estadodetalleautoriconsep.getGeneralEntityOriginal());
					
					estadodetalleautoriconsepLocal.setId(estadodetalleautoriconsep.getId());	
					estadodetalleautoriconsepLocal.setVersionRow(estadodetalleautoriconsep.getVersionRow());	
					estadodetalleautoriconsepLocal.setcodigo(estadodetalleautoriconsep.getcodigo());	
					estadodetalleautoriconsepLocal.setnombre(estadodetalleautoriconsep.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetalleautoriconsep.getIsDeleted()) {
				if(!existe) {
					estadodetalleautoriconseps.add(estadodetalleautoriconsep);
				}
			} else {
				if(estadodetalleautoriconsepEncontrado!=null && permiteQuitar)  {
					estadodetalleautoriconseps.remove(estadodetalleautoriconsepEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleAutoriConsep estadodetalleautoriconsep,List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps) throws Exception {
		try	{			
			for(EstadoDetalleAutoriConsep estadodetalleautoriconsepLocal:estadodetalleautoriconseps) {
				if(estadodetalleautoriconsepLocal.getId().equals(estadodetalleautoriconsep.getId())) {
					estadodetalleautoriconsepLocal.setIsSelected(estadodetalleautoriconsep.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleAutoriConsep(List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsAux) throws Exception {
		//this.estadodetalleautoriconsepsAux=estadodetalleautoriconsepsAux;
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux:estadodetalleautoriconsepsAux) {
			if(estadodetalleautoriconsepAux.getIsChanged()) {
				estadodetalleautoriconsepAux.setIsChanged(false);
			}		
			
			if(estadodetalleautoriconsepAux.getIsNew()) {
				estadodetalleautoriconsepAux.setIsNew(false);
			}	
			
			if(estadodetalleautoriconsepAux.getIsDeleted()) {
				estadodetalleautoriconsepAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsepAux) throws Exception {
		//this.estadodetalleautoriconsepAux=estadodetalleautoriconsepAux;
		
			if(estadodetalleautoriconsepAux.getIsChanged()) {
				estadodetalleautoriconsepAux.setIsChanged(false);
			}		
			
			if(estadodetalleautoriconsepAux.getIsNew()) {
				estadodetalleautoriconsepAux.setIsNew(false);
			}	
			
			if(estadodetalleautoriconsepAux.getIsDeleted()) {
				estadodetalleautoriconsepAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleAutoriConsep estadodetalleautoriconsepAsignar,EstadoDetalleAutoriConsep estadodetalleautoriconsep) throws Exception {
		estadodetalleautoriconsepAsignar.setId(estadodetalleautoriconsep.getId());	
		estadodetalleautoriconsepAsignar.setVersionRow(estadodetalleautoriconsep.getVersionRow());	
		estadodetalleautoriconsepAsignar.setcodigo(estadodetalleautoriconsep.getcodigo());	
		estadodetalleautoriconsepAsignar.setnombre(estadodetalleautoriconsep.getnombre());	
	}
	
	public static void inicializarEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep) throws Exception {
		try {
				estadodetalleautoriconsep.setId(0L);	
					
				estadodetalleautoriconsep.setcodigo("");	
				estadodetalleautoriconsep.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleAutoriConsep(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleAutoriConsep(String sTipo,Row row,Workbook workbook,EstadoDetalleAutoriConsep estadodetalleautoriconsep,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleautoriconsep.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleautoriconsep.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleAutoriConsep=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleAutoriConsep() {
		return this.sFinalQueryEstadoDetalleAutoriConsep;
	}
	
	public void setsFinalQueryEstadoDetalleAutoriConsep(String sFinalQueryEstadoDetalleAutoriConsep) {
		this.sFinalQueryEstadoDetalleAutoriConsep= sFinalQueryEstadoDetalleAutoriConsep;
	}
	
	public Border resaltarSeleccionarEstadoDetalleAutoriConsep=null;
	
	public Border setResaltarSeleccionarEstadoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetalleautoriconsepBeanSwingJInternalFrame.jTtoolBarEstadoDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleAutoriConsep= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleAutoriConsep() {
		return this.resaltarSeleccionarEstadoDetalleAutoriConsep;
	}
	
	public void setResaltarSeleccionarEstadoDetalleAutoriConsep(Border borderResaltarSeleccionarEstadoDetalleAutoriConsep) {
		this.resaltarSeleccionarEstadoDetalleAutoriConsep= borderResaltarSeleccionarEstadoDetalleAutoriConsep;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleAutoriConsep=null;
	public Boolean mostraridEstadoDetalleAutoriConsep=true;
	public Boolean activaridEstadoDetalleAutoriConsep=true;

	public Border resaltarcodigoEstadoDetalleAutoriConsep=null;
	public Boolean mostrarcodigoEstadoDetalleAutoriConsep=true;
	public Boolean activarcodigoEstadoDetalleAutoriConsep=true;

	public Border resaltarnombreEstadoDetalleAutoriConsep=null;
	public Boolean mostrarnombreEstadoDetalleAutoriConsep=true;
	public Boolean activarnombreEstadoDetalleAutoriConsep=true;

	
	

	public Border setResaltaridEstadoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleautoriconsepBeanSwingJInternalFrame.jTtoolBarEstadoDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleAutoriConsep() {
		return this.resaltaridEstadoDetalleAutoriConsep;
	}

	public void setResaltaridEstadoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltaridEstadoDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleAutoriConsep() {
		return this.mostraridEstadoDetalleAutoriConsep;
	}

	public void setMostraridEstadoDetalleAutoriConsep(Boolean mostraridEstadoDetalleAutoriConsep) {
		this.mostraridEstadoDetalleAutoriConsep= mostraridEstadoDetalleAutoriConsep;
	}

	public Boolean getActivaridEstadoDetalleAutoriConsep() {
		return this.activaridEstadoDetalleAutoriConsep;
	}

	public void setActivaridEstadoDetalleAutoriConsep(Boolean activaridEstadoDetalleAutoriConsep) {
		this.activaridEstadoDetalleAutoriConsep= activaridEstadoDetalleAutoriConsep;
	}

	public Border setResaltarcodigoEstadoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleautoriconsepBeanSwingJInternalFrame.jTtoolBarEstadoDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleAutoriConsep() {
		return this.resaltarcodigoEstadoDetalleAutoriConsep;
	}

	public void setResaltarcodigoEstadoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleAutoriConsep() {
		return this.mostrarcodigoEstadoDetalleAutoriConsep;
	}

	public void setMostrarcodigoEstadoDetalleAutoriConsep(Boolean mostrarcodigoEstadoDetalleAutoriConsep) {
		this.mostrarcodigoEstadoDetalleAutoriConsep= mostrarcodigoEstadoDetalleAutoriConsep;
	}

	public Boolean getActivarcodigoEstadoDetalleAutoriConsep() {
		return this.activarcodigoEstadoDetalleAutoriConsep;
	}

	public void setActivarcodigoEstadoDetalleAutoriConsep(Boolean activarcodigoEstadoDetalleAutoriConsep) {
		this.activarcodigoEstadoDetalleAutoriConsep= activarcodigoEstadoDetalleAutoriConsep;
	}

	public Border setResaltarnombreEstadoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleautoriconsepBeanSwingJInternalFrame.jTtoolBarEstadoDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleAutoriConsep() {
		return this.resaltarnombreEstadoDetalleAutoriConsep;
	}

	public void setResaltarnombreEstadoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleAutoriConsep() {
		return this.mostrarnombreEstadoDetalleAutoriConsep;
	}

	public void setMostrarnombreEstadoDetalleAutoriConsep(Boolean mostrarnombreEstadoDetalleAutoriConsep) {
		this.mostrarnombreEstadoDetalleAutoriConsep= mostrarnombreEstadoDetalleAutoriConsep;
	}

	public Boolean getActivarnombreEstadoDetalleAutoriConsep() {
		return this.activarnombreEstadoDetalleAutoriConsep;
	}

	public void setActivarnombreEstadoDetalleAutoriConsep(Boolean activarnombreEstadoDetalleAutoriConsep) {
		this.activarnombreEstadoDetalleAutoriConsep= activarnombreEstadoDetalleAutoriConsep;
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
		
		
		this.setMostraridEstadoDetalleAutoriConsep(esInicial);
		this.setMostrarcodigoEstadoDetalleAutoriConsep(esInicial);
		this.setMostrarnombreEstadoDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleAutoriConsep(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleAutoriConsep(esInicial);
		this.setActivarcodigoEstadoDetalleAutoriConsep(esInicial);
		this.setActivarnombreEstadoDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleAutoriConsep(esInicial);
		this.setResaltarcodigoEstadoDetalleAutoriConsep(esInicial);
		this.setResaltarnombreEstadoDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleAutoriConsep(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleAutoriConsepBeanSwingJInternalFrame estadodetalleautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}