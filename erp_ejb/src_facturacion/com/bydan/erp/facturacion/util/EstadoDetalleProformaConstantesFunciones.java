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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoDetalleProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoDetalleProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoDetalleProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetalleProformaConstantesFunciones extends EstadoDetalleProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleProforma"+EstadoDetalleProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleProformaConstantesFunciones.SCHEMA+"_"+EstadoDetalleProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleProformaConstantesFunciones.SCHEMA+"_"+EstadoDetalleProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleProformaConstantesFunciones.SCHEMA+"_"+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleProformaConstantesFunciones.SCHEMA+"_"+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleProforma";
	public static final String OBJECTNAME="estadodetalleproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_detalle_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetalleproforma from "+EstadoDetalleProformaConstantesFunciones.SPERSISTENCENAME+" estadodetalleproforma";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".id,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDetalleProformaConstantesFuncionesAdditional estadodetalleproformaConstantesFuncionesAdditional=null;
	
	public EstadoDetalleProformaConstantesFuncionesAdditional getEstadoDetalleProformaConstantesFuncionesAdditional() {
		return this.estadodetalleproformaConstantesFuncionesAdditional;
	}
	
	public void setEstadoDetalleProformaConstantesFuncionesAdditional(EstadoDetalleProformaConstantesFuncionesAdditional estadodetalleproformaConstantesFuncionesAdditional) {
		try {
			this.estadodetalleproformaConstantesFuncionesAdditional=estadodetalleproformaConstantesFuncionesAdditional;
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
	
	public static String getEstadoDetalleProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleProformaConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleProformaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleProformaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleProformaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleProformaDescripcion(EstadoDetalleProforma estadodetalleproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetalleproforma !=null/* && estadodetalleproforma.getId()!=0*/) {
			sDescripcion=estadodetalleproforma.getcodigo();//estadodetalleproformaestadodetalleproforma.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleProformaDescripcionDetallado(EstadoDetalleProforma estadodetalleproforma) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleProformaConstantesFunciones.ID+"=";
		sDescripcion+=estadodetalleproforma.getId().toString()+",";
		sDescripcion+=EstadoDetalleProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetalleproforma.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleProformaConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetalleproforma.getcodigo()+",";
		sDescripcion+=EstadoDetalleProformaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetalleproforma.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleProformaDescripcion(EstadoDetalleProforma estadodetalleproforma,String sValor) throws Exception {			
		if(estadodetalleproforma !=null) {
			estadodetalleproforma.setcodigo(sValor);;//estadodetalleproformaestadodetalleproforma.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetalleproforma.setcodigo(estadodetalleproforma.getcodigo().trim());
		estadodetalleproforma.setnombre(estadodetalleproforma.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleProformas(List<EstadoDetalleProforma> estadodetalleproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleProforma estadodetalleproforma: estadodetalleproformas) {
			estadodetalleproforma.setcodigo(estadodetalleproforma.getcodigo().trim());
			estadodetalleproforma.setnombre(estadodetalleproforma.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetalleproforma.getConCambioAuxiliar()) {
			estadodetalleproforma.setIsDeleted(estadodetalleproforma.getIsDeletedAuxiliar());	
			estadodetalleproforma.setIsNew(estadodetalleproforma.getIsNewAuxiliar());	
			estadodetalleproforma.setIsChanged(estadodetalleproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetalleproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetalleproforma.setIsDeletedAuxiliar(false);	
			estadodetalleproforma.setIsNewAuxiliar(false);	
			estadodetalleproforma.setIsChangedAuxiliar(false);
			
			estadodetalleproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleProformas(List<EstadoDetalleProforma> estadodetalleproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleProforma estadodetalleproforma : estadodetalleproformas) {
			if(conAsignarBase && estadodetalleproforma.getConCambioAuxiliar()) {
				estadodetalleproforma.setIsDeleted(estadodetalleproforma.getIsDeletedAuxiliar());	
				estadodetalleproforma.setIsNew(estadodetalleproforma.getIsNewAuxiliar());	
				estadodetalleproforma.setIsChanged(estadodetalleproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetalleproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetalleproforma.setIsDeletedAuxiliar(false);	
				estadodetalleproforma.setIsNewAuxiliar(false);	
				estadodetalleproforma.setIsChangedAuxiliar(false);
				
				estadodetalleproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleProformas(List<EstadoDetalleProforma> estadodetalleproformas,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleProforma estadodetalleproforma: estadodetalleproformas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleProforma(List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProforma estadodetalleproformaAux) throws Exception  {
		EstadoDetalleProformaConstantesFunciones.InicializarValoresEstadoDetalleProforma(estadodetalleproformaAux,true);
		
		for(EstadoDetalleProforma estadodetalleproforma: estadodetalleproformas) {
			if(estadodetalleproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleProformaConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProforma estadodetalleproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleProforma estadodetalleproformaAux: estadodetalleproformas) {
			if(estadodetalleproformaAux!=null && estadodetalleproforma!=null) {
				if((estadodetalleproformaAux.getId()==null && estadodetalleproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetalleproformaAux.getId()!=null && estadodetalleproforma.getId()!=null){
					if(estadodetalleproformaAux.getId().equals(estadodetalleproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleProforma(List<EstadoDetalleProforma> estadodetalleproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleProforma estadodetalleproforma: estadodetalleproformas) {			
			if(estadodetalleproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleProformaConstantesFunciones.LABEL_ID, EstadoDetalleProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleProformaConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleProformaConstantesFunciones.LABEL_CODIGO, EstadoDetalleProformaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleProformaConstantesFunciones.LABEL_NOMBRE, EstadoDetalleProformaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleProformaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleProformaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleProforma() throws Exception  {
		return EstadoDetalleProformaConstantesFunciones.getTiposSeleccionarEstadoDetalleProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleProforma(Boolean conFk) throws Exception  {
		return EstadoDetalleProformaConstantesFunciones.getTiposSeleccionarEstadoDetalleProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleProformaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleProformaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleProformaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleProformaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproformaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleProforma(List<EstadoDetalleProforma> estadodetalleproformasTemp) throws Exception {
		for(EstadoDetalleProforma estadodetalleproformaAux:estadodetalleproformasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleProformaConstantesFunciones.getClassesRelationshipsOfEstadoDetalleProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleProforma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProforma.class)) {
						classes.add(new Classe(DetalleProforma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleProformaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
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
	public static void actualizarLista(EstadoDetalleProforma estadodetalleproforma,List<EstadoDetalleProforma> estadodetalleproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleProforma estadodetalleproformaEncontrado=null;
			
			for(EstadoDetalleProforma estadodetalleproformaLocal:estadodetalleproformas) {
				if(estadodetalleproformaLocal.getId().equals(estadodetalleproforma.getId())) {
					estadodetalleproformaEncontrado=estadodetalleproformaLocal;
					
					estadodetalleproformaLocal.setIsChanged(estadodetalleproforma.getIsChanged());
					estadodetalleproformaLocal.setIsNew(estadodetalleproforma.getIsNew());
					estadodetalleproformaLocal.setIsDeleted(estadodetalleproforma.getIsDeleted());
					
					estadodetalleproformaLocal.setGeneralEntityOriginal(estadodetalleproforma.getGeneralEntityOriginal());
					
					estadodetalleproformaLocal.setId(estadodetalleproforma.getId());	
					estadodetalleproformaLocal.setVersionRow(estadodetalleproforma.getVersionRow());	
					estadodetalleproformaLocal.setcodigo(estadodetalleproforma.getcodigo());	
					estadodetalleproformaLocal.setnombre(estadodetalleproforma.getnombre());	
					
					
					estadodetalleproformaLocal.setDetalleProformas(estadodetalleproforma.getDetalleProformas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetalleproforma.getIsDeleted()) {
				if(!existe) {
					estadodetalleproformas.add(estadodetalleproforma);
				}
			} else {
				if(estadodetalleproformaEncontrado!=null && permiteQuitar)  {
					estadodetalleproformas.remove(estadodetalleproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleProforma estadodetalleproforma,List<EstadoDetalleProforma> estadodetalleproformas) throws Exception {
		try	{			
			for(EstadoDetalleProforma estadodetalleproformaLocal:estadodetalleproformas) {
				if(estadodetalleproformaLocal.getId().equals(estadodetalleproforma.getId())) {
					estadodetalleproformaLocal.setIsSelected(estadodetalleproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleProforma(List<EstadoDetalleProforma> estadodetalleproformasAux) throws Exception {
		//this.estadodetalleproformasAux=estadodetalleproformasAux;
		
		for(EstadoDetalleProforma estadodetalleproformaAux:estadodetalleproformasAux) {
			if(estadodetalleproformaAux.getIsChanged()) {
				estadodetalleproformaAux.setIsChanged(false);
			}		
			
			if(estadodetalleproformaAux.getIsNew()) {
				estadodetalleproformaAux.setIsNew(false);
			}	
			
			if(estadodetalleproformaAux.getIsDeleted()) {
				estadodetalleproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproformaAux) throws Exception {
		//this.estadodetalleproformaAux=estadodetalleproformaAux;
		
			if(estadodetalleproformaAux.getIsChanged()) {
				estadodetalleproformaAux.setIsChanged(false);
			}		
			
			if(estadodetalleproformaAux.getIsNew()) {
				estadodetalleproformaAux.setIsNew(false);
			}	
			
			if(estadodetalleproformaAux.getIsDeleted()) {
				estadodetalleproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleProforma estadodetalleproformaAsignar,EstadoDetalleProforma estadodetalleproforma) throws Exception {
		estadodetalleproformaAsignar.setId(estadodetalleproforma.getId());	
		estadodetalleproformaAsignar.setVersionRow(estadodetalleproforma.getVersionRow());	
		estadodetalleproformaAsignar.setcodigo(estadodetalleproforma.getcodigo());	
		estadodetalleproformaAsignar.setnombre(estadodetalleproforma.getnombre());	
	}
	
	public static void inicializarEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma) throws Exception {
		try {
				estadodetalleproforma.setId(0L);	
					
				estadodetalleproforma.setcodigo("");	
				estadodetalleproforma.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleProformaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleProformaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleProforma(String sTipo,Row row,Workbook workbook,EstadoDetalleProforma estadodetalleproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleproforma.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleproforma.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleProforma() {
		return this.sFinalQueryEstadoDetalleProforma;
	}
	
	public void setsFinalQueryEstadoDetalleProforma(String sFinalQueryEstadoDetalleProforma) {
		this.sFinalQueryEstadoDetalleProforma= sFinalQueryEstadoDetalleProforma;
	}
	
	public Border resaltarSeleccionarEstadoDetalleProforma=null;
	
	public Border setResaltarSeleccionarEstadoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetalleproformaBeanSwingJInternalFrame.jTtoolBarEstadoDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleProforma() {
		return this.resaltarSeleccionarEstadoDetalleProforma;
	}
	
	public void setResaltarSeleccionarEstadoDetalleProforma(Border borderResaltarSeleccionarEstadoDetalleProforma) {
		this.resaltarSeleccionarEstadoDetalleProforma= borderResaltarSeleccionarEstadoDetalleProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleProforma=null;
	public Boolean mostraridEstadoDetalleProforma=true;
	public Boolean activaridEstadoDetalleProforma=true;

	public Border resaltarcodigoEstadoDetalleProforma=null;
	public Boolean mostrarcodigoEstadoDetalleProforma=true;
	public Boolean activarcodigoEstadoDetalleProforma=true;

	public Border resaltarnombreEstadoDetalleProforma=null;
	public Boolean mostrarnombreEstadoDetalleProforma=true;
	public Boolean activarnombreEstadoDetalleProforma=true;

	
	

	public Border setResaltaridEstadoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleproformaBeanSwingJInternalFrame.jTtoolBarEstadoDetalleProforma.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleProforma() {
		return this.resaltaridEstadoDetalleProforma;
	}

	public void setResaltaridEstadoDetalleProforma(Border borderResaltar) {
		this.resaltaridEstadoDetalleProforma= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleProforma() {
		return this.mostraridEstadoDetalleProforma;
	}

	public void setMostraridEstadoDetalleProforma(Boolean mostraridEstadoDetalleProforma) {
		this.mostraridEstadoDetalleProforma= mostraridEstadoDetalleProforma;
	}

	public Boolean getActivaridEstadoDetalleProforma() {
		return this.activaridEstadoDetalleProforma;
	}

	public void setActivaridEstadoDetalleProforma(Boolean activaridEstadoDetalleProforma) {
		this.activaridEstadoDetalleProforma= activaridEstadoDetalleProforma;
	}

	public Border setResaltarcodigoEstadoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleproformaBeanSwingJInternalFrame.jTtoolBarEstadoDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleProforma() {
		return this.resaltarcodigoEstadoDetalleProforma;
	}

	public void setResaltarcodigoEstadoDetalleProforma(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleProforma() {
		return this.mostrarcodigoEstadoDetalleProforma;
	}

	public void setMostrarcodigoEstadoDetalleProforma(Boolean mostrarcodigoEstadoDetalleProforma) {
		this.mostrarcodigoEstadoDetalleProforma= mostrarcodigoEstadoDetalleProforma;
	}

	public Boolean getActivarcodigoEstadoDetalleProforma() {
		return this.activarcodigoEstadoDetalleProforma;
	}

	public void setActivarcodigoEstadoDetalleProforma(Boolean activarcodigoEstadoDetalleProforma) {
		this.activarcodigoEstadoDetalleProforma= activarcodigoEstadoDetalleProforma;
	}

	public Border setResaltarnombreEstadoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleproformaBeanSwingJInternalFrame.jTtoolBarEstadoDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleProforma() {
		return this.resaltarnombreEstadoDetalleProforma;
	}

	public void setResaltarnombreEstadoDetalleProforma(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleProforma() {
		return this.mostrarnombreEstadoDetalleProforma;
	}

	public void setMostrarnombreEstadoDetalleProforma(Boolean mostrarnombreEstadoDetalleProforma) {
		this.mostrarnombreEstadoDetalleProforma= mostrarnombreEstadoDetalleProforma;
	}

	public Boolean getActivarnombreEstadoDetalleProforma() {
		return this.activarnombreEstadoDetalleProforma;
	}

	public void setActivarnombreEstadoDetalleProforma(Boolean activarnombreEstadoDetalleProforma) {
		this.activarnombreEstadoDetalleProforma= activarnombreEstadoDetalleProforma;
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
		
		
		this.setMostraridEstadoDetalleProforma(esInicial);
		this.setMostrarcodigoEstadoDetalleProforma(esInicial);
		this.setMostrarnombreEstadoDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleProforma(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleProforma(esInicial);
		this.setActivarcodigoEstadoDetalleProforma(esInicial);
		this.setActivarnombreEstadoDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleProforma(esInicial);
		this.setResaltarcodigoEstadoDetalleProforma(esInicial);
		this.setResaltarnombreEstadoDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleProformaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleProforma(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleProformaEstadoDetalleProforma=null;

	public Border getResaltarDetalleProformaEstadoDetalleProforma() {
		return this.resaltarDetalleProformaEstadoDetalleProforma;
	}

	public void setResaltarDetalleProformaEstadoDetalleProforma(Border borderResaltarDetalleProforma) {
		if(borderResaltarDetalleProforma!=null) {
			this.resaltarDetalleProformaEstadoDetalleProforma= borderResaltarDetalleProforma;
		}
	}

	public Border setResaltarDetalleProformaEstadoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleproformaBeanSwingJInternalFrame.jTtoolBarEstadoDetalleProforma.setBorder(borderResaltarDetalleProforma);
			
		this.resaltarDetalleProformaEstadoDetalleProforma= borderResaltarDetalleProforma;

		 return borderResaltarDetalleProforma;
	}



	public Boolean mostrarDetalleProformaEstadoDetalleProforma=true;

	public Boolean getMostrarDetalleProformaEstadoDetalleProforma() {
		return this.mostrarDetalleProformaEstadoDetalleProforma;
	}

	public void setMostrarDetalleProformaEstadoDetalleProforma(Boolean visibilidadResaltarDetalleProforma) {
		this.mostrarDetalleProformaEstadoDetalleProforma= visibilidadResaltarDetalleProforma;
	}



	public Boolean activarDetalleProformaEstadoDetalleProforma=true;

	public Boolean gethabilitarResaltarDetalleProformaEstadoDetalleProforma() {
		return this.activarDetalleProformaEstadoDetalleProforma;
	}

	public void setActivarDetalleProformaEstadoDetalleProforma(Boolean habilitarResaltarDetalleProforma) {
		this.activarDetalleProformaEstadoDetalleProforma= habilitarResaltarDetalleProforma;
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

		this.setMostrarDetalleProformaEstadoDetalleProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setMostrarDetalleProformaEstadoDetalleProforma(esAsigna);
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

		this.setActivarDetalleProformaEstadoDetalleProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setActivarDetalleProformaEstadoDetalleProforma(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleProformaBeanSwingJInternalFrame estadodetalleproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleProformaEstadoDetalleProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setResaltarDetalleProformaEstadoDetalleProforma(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}