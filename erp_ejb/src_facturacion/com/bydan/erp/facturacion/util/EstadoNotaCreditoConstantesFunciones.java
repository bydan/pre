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


import com.bydan.erp.facturacion.util.EstadoNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoNotaCreditoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoNotaCreditoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoNotaCredito";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoNotaCredito"+EstadoNotaCreditoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoNotaCreditoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoNotaCreditoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoNotaCreditoConstantesFunciones.SCHEMA+"_"+EstadoNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoNotaCreditoConstantesFunciones.SCHEMA+"_"+EstadoNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoNotaCreditoConstantesFunciones.SCHEMA+"_"+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoNotaCreditoConstantesFunciones.SCHEMA+"_"+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoNotaCreditoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoNotaCreditoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Estado Nota Credito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoNotaCredito";
	public static final String OBJECTNAME="estadonotacredito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_nota_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadonotacredito from "+EstadoNotaCreditoConstantesFunciones.SPERSISTENCENAME+" estadonotacredito";
	public static String QUERYSELECTNATIVE="select "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".id,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".codigo,"+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME+".nombre from "+EstadoNotaCreditoConstantesFunciones.SCHEMA+"."+EstadoNotaCreditoConstantesFunciones.TABLENAME;//+" as "+EstadoNotaCreditoConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoNotaCreditoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoNotaCreditoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoNotaCreditoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoNotaCreditoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoNotaCreditoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoNotaCreditoDescripcion(EstadoNotaCredito estadonotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadonotacredito !=null/* && estadonotacredito.getId()!=0*/) {
			sDescripcion=estadonotacredito.getnombre();//estadonotacreditoestadonotacredito.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoNotaCreditoDescripcionDetallado(EstadoNotaCredito estadonotacredito) {
		String sDescripcion="";
			
		sDescripcion+=EstadoNotaCreditoConstantesFunciones.ID+"=";
		sDescripcion+=estadonotacredito.getId().toString()+",";
		sDescripcion+=EstadoNotaCreditoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadonotacredito.getVersionRow().toString()+",";
		sDescripcion+=EstadoNotaCreditoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadonotacredito.getcodigo()+",";
		sDescripcion+=EstadoNotaCreditoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadonotacredito.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoNotaCreditoDescripcion(EstadoNotaCredito estadonotacredito,String sValor) throws Exception {			
		if(estadonotacredito !=null) {
			estadonotacredito.setnombre(sValor);;//estadonotacreditoestadonotacredito.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoNotaCredito(EstadoNotaCredito estadonotacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadonotacredito.setcodigo(estadonotacredito.getcodigo().trim());
		estadonotacredito.setnombre(estadonotacredito.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoNotaCreditos(List<EstadoNotaCredito> estadonotacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoNotaCredito estadonotacredito: estadonotacreditos) {
			estadonotacredito.setcodigo(estadonotacredito.getcodigo().trim());
			estadonotacredito.setnombre(estadonotacredito.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNotaCredito(EstadoNotaCredito estadonotacredito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadonotacredito.getConCambioAuxiliar()) {
			estadonotacredito.setIsDeleted(estadonotacredito.getIsDeletedAuxiliar());	
			estadonotacredito.setIsNew(estadonotacredito.getIsNewAuxiliar());	
			estadonotacredito.setIsChanged(estadonotacredito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadonotacredito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadonotacredito.setIsDeletedAuxiliar(false);	
			estadonotacredito.setIsNewAuxiliar(false);	
			estadonotacredito.setIsChangedAuxiliar(false);
			
			estadonotacredito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNotaCreditos(List<EstadoNotaCredito> estadonotacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoNotaCredito estadonotacredito : estadonotacreditos) {
			if(conAsignarBase && estadonotacredito.getConCambioAuxiliar()) {
				estadonotacredito.setIsDeleted(estadonotacredito.getIsDeletedAuxiliar());	
				estadonotacredito.setIsNew(estadonotacredito.getIsNewAuxiliar());	
				estadonotacredito.setIsChanged(estadonotacredito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadonotacredito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadonotacredito.setIsDeletedAuxiliar(false);	
				estadonotacredito.setIsNewAuxiliar(false);	
				estadonotacredito.setIsChangedAuxiliar(false);
				
				estadonotacredito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoNotaCredito(EstadoNotaCredito estadonotacredito,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoNotaCreditos(List<EstadoNotaCredito> estadonotacreditos,Boolean conEnteros) throws Exception  {
		
		for(EstadoNotaCredito estadonotacredito: estadonotacreditos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoNotaCredito(List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCredito estadonotacreditoAux) throws Exception  {
		EstadoNotaCreditoConstantesFunciones.InicializarValoresEstadoNotaCredito(estadonotacreditoAux,true);
		
		for(EstadoNotaCredito estadonotacredito: estadonotacreditos) {
			if(estadonotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoNotaCreditoConstantesFunciones.getArrayColumnasGlobalesEstadoNotaCredito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCredito estadonotacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoNotaCredito estadonotacreditoAux: estadonotacreditos) {
			if(estadonotacreditoAux!=null && estadonotacredito!=null) {
				if((estadonotacreditoAux.getId()==null && estadonotacredito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadonotacreditoAux.getId()!=null && estadonotacredito.getId()!=null){
					if(estadonotacreditoAux.getId().equals(estadonotacredito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoNotaCredito(List<EstadoNotaCredito> estadonotacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoNotaCredito estadonotacredito: estadonotacreditos) {			
			if(estadonotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoNotaCredito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoNotaCreditoConstantesFunciones.LABEL_ID, EstadoNotaCreditoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNotaCreditoConstantesFunciones.LABEL_VERSIONROW, EstadoNotaCreditoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNotaCreditoConstantesFunciones.LABEL_CODIGO, EstadoNotaCreditoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNotaCreditoConstantesFunciones.LABEL_NOMBRE, EstadoNotaCreditoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoNotaCredito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoNotaCreditoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNotaCreditoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNotaCreditoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNotaCreditoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNotaCredito() throws Exception  {
		return EstadoNotaCreditoConstantesFunciones.getTiposSeleccionarEstadoNotaCredito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNotaCredito(Boolean conFk) throws Exception  {
		return EstadoNotaCreditoConstantesFunciones.getTiposSeleccionarEstadoNotaCredito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNotaCredito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNotaCreditoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoNotaCreditoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNotaCreditoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoNotaCreditoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoNotaCredito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNotaCredito(EstadoNotaCredito estadonotacreditoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNotaCredito(List<EstadoNotaCredito> estadonotacreditosTemp) throws Exception {
		for(EstadoNotaCredito estadonotacreditoAux:estadonotacreditosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNotaCreditoConstantesFunciones.getClassesRelationshipsOfEstadoNotaCredito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NotaCreditoSoli.class));
				classes.add(new Classe(NotaCredito.class));
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCredito.class)) {
						classes.add(new Classe(NotaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNotaCreditoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoNotaCredito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
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
	public static void actualizarLista(EstadoNotaCredito estadonotacredito,List<EstadoNotaCredito> estadonotacreditos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoNotaCredito estadonotacreditoEncontrado=null;
			
			for(EstadoNotaCredito estadonotacreditoLocal:estadonotacreditos) {
				if(estadonotacreditoLocal.getId().equals(estadonotacredito.getId())) {
					estadonotacreditoEncontrado=estadonotacreditoLocal;
					
					estadonotacreditoLocal.setIsChanged(estadonotacredito.getIsChanged());
					estadonotacreditoLocal.setIsNew(estadonotacredito.getIsNew());
					estadonotacreditoLocal.setIsDeleted(estadonotacredito.getIsDeleted());
					
					estadonotacreditoLocal.setGeneralEntityOriginal(estadonotacredito.getGeneralEntityOriginal());
					
					estadonotacreditoLocal.setId(estadonotacredito.getId());	
					estadonotacreditoLocal.setVersionRow(estadonotacredito.getVersionRow());	
					estadonotacreditoLocal.setcodigo(estadonotacredito.getcodigo());	
					estadonotacreditoLocal.setnombre(estadonotacredito.getnombre());	
					
					
					estadonotacreditoLocal.setNotaCreditoSoliSolis(estadonotacredito.getNotaCreditoSoliSolis());
					estadonotacreditoLocal.setNotaCreditoPuntoVentaPuntoVentas(estadonotacredito.getNotaCreditoPuntoVentaPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadonotacredito.getIsDeleted()) {
				if(!existe) {
					estadonotacreditos.add(estadonotacredito);
				}
			} else {
				if(estadonotacreditoEncontrado!=null && permiteQuitar)  {
					estadonotacreditos.remove(estadonotacreditoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoNotaCredito estadonotacredito,List<EstadoNotaCredito> estadonotacreditos) throws Exception {
		try	{			
			for(EstadoNotaCredito estadonotacreditoLocal:estadonotacreditos) {
				if(estadonotacreditoLocal.getId().equals(estadonotacredito.getId())) {
					estadonotacreditoLocal.setIsSelected(estadonotacredito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoNotaCredito(List<EstadoNotaCredito> estadonotacreditosAux) throws Exception {
		//this.estadonotacreditosAux=estadonotacreditosAux;
		
		for(EstadoNotaCredito estadonotacreditoAux:estadonotacreditosAux) {
			if(estadonotacreditoAux.getIsChanged()) {
				estadonotacreditoAux.setIsChanged(false);
			}		
			
			if(estadonotacreditoAux.getIsNew()) {
				estadonotacreditoAux.setIsNew(false);
			}	
			
			if(estadonotacreditoAux.getIsDeleted()) {
				estadonotacreditoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoNotaCredito(EstadoNotaCredito estadonotacreditoAux) throws Exception {
		//this.estadonotacreditoAux=estadonotacreditoAux;
		
			if(estadonotacreditoAux.getIsChanged()) {
				estadonotacreditoAux.setIsChanged(false);
			}		
			
			if(estadonotacreditoAux.getIsNew()) {
				estadonotacreditoAux.setIsNew(false);
			}	
			
			if(estadonotacreditoAux.getIsDeleted()) {
				estadonotacreditoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoNotaCredito estadonotacreditoAsignar,EstadoNotaCredito estadonotacredito) throws Exception {
		estadonotacreditoAsignar.setId(estadonotacredito.getId());	
		estadonotacreditoAsignar.setVersionRow(estadonotacredito.getVersionRow());	
		estadonotacreditoAsignar.setcodigo(estadonotacredito.getcodigo());	
		estadonotacreditoAsignar.setnombre(estadonotacredito.getnombre());	
	}
	
	public static void inicializarEstadoNotaCredito(EstadoNotaCredito estadonotacredito) throws Exception {
		try {
				estadonotacredito.setId(0L);	
					
				estadonotacredito.setcodigo("");	
				estadonotacredito.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoNotaCredito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNotaCreditoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNotaCreditoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoNotaCredito(String sTipo,Row row,Workbook workbook,EstadoNotaCredito estadonotacredito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonotacredito.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonotacredito.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoNotaCredito=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoNotaCredito() {
		return this.sFinalQueryEstadoNotaCredito;
	}
	
	public void setsFinalQueryEstadoNotaCredito(String sFinalQueryEstadoNotaCredito) {
		this.sFinalQueryEstadoNotaCredito= sFinalQueryEstadoNotaCredito;
	}
	
	public Border resaltarSeleccionarEstadoNotaCredito=null;
	
	public Border setResaltarSeleccionarEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoNotaCredito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoNotaCredito() {
		return this.resaltarSeleccionarEstadoNotaCredito;
	}
	
	public void setResaltarSeleccionarEstadoNotaCredito(Border borderResaltarSeleccionarEstadoNotaCredito) {
		this.resaltarSeleccionarEstadoNotaCredito= borderResaltarSeleccionarEstadoNotaCredito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoNotaCredito=null;
	public Boolean mostraridEstadoNotaCredito=true;
	public Boolean activaridEstadoNotaCredito=true;

	public Border resaltarcodigoEstadoNotaCredito=null;
	public Boolean mostrarcodigoEstadoNotaCredito=true;
	public Boolean activarcodigoEstadoNotaCredito=true;

	public Border resaltarnombreEstadoNotaCredito=null;
	public Boolean mostrarnombreEstadoNotaCredito=true;
	public Boolean activarnombreEstadoNotaCredito=true;

	
	

	public Border setResaltaridEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltar);
		
		this.resaltaridEstadoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoNotaCredito() {
		return this.resaltaridEstadoNotaCredito;
	}

	public void setResaltaridEstadoNotaCredito(Border borderResaltar) {
		this.resaltaridEstadoNotaCredito= borderResaltar;
	}

	public Boolean getMostraridEstadoNotaCredito() {
		return this.mostraridEstadoNotaCredito;
	}

	public void setMostraridEstadoNotaCredito(Boolean mostraridEstadoNotaCredito) {
		this.mostraridEstadoNotaCredito= mostraridEstadoNotaCredito;
	}

	public Boolean getActivaridEstadoNotaCredito() {
		return this.activaridEstadoNotaCredito;
	}

	public void setActivaridEstadoNotaCredito(Boolean activaridEstadoNotaCredito) {
		this.activaridEstadoNotaCredito= activaridEstadoNotaCredito;
	}

	public Border setResaltarcodigoEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoNotaCredito() {
		return this.resaltarcodigoEstadoNotaCredito;
	}

	public void setResaltarcodigoEstadoNotaCredito(Border borderResaltar) {
		this.resaltarcodigoEstadoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoNotaCredito() {
		return this.mostrarcodigoEstadoNotaCredito;
	}

	public void setMostrarcodigoEstadoNotaCredito(Boolean mostrarcodigoEstadoNotaCredito) {
		this.mostrarcodigoEstadoNotaCredito= mostrarcodigoEstadoNotaCredito;
	}

	public Boolean getActivarcodigoEstadoNotaCredito() {
		return this.activarcodigoEstadoNotaCredito;
	}

	public void setActivarcodigoEstadoNotaCredito(Boolean activarcodigoEstadoNotaCredito) {
		this.activarcodigoEstadoNotaCredito= activarcodigoEstadoNotaCredito;
	}

	public Border setResaltarnombreEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoNotaCredito() {
		return this.resaltarnombreEstadoNotaCredito;
	}

	public void setResaltarnombreEstadoNotaCredito(Border borderResaltar) {
		this.resaltarnombreEstadoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoNotaCredito() {
		return this.mostrarnombreEstadoNotaCredito;
	}

	public void setMostrarnombreEstadoNotaCredito(Boolean mostrarnombreEstadoNotaCredito) {
		this.mostrarnombreEstadoNotaCredito= mostrarnombreEstadoNotaCredito;
	}

	public Boolean getActivarnombreEstadoNotaCredito() {
		return this.activarnombreEstadoNotaCredito;
	}

	public void setActivarnombreEstadoNotaCredito(Boolean activarnombreEstadoNotaCredito) {
		this.activarnombreEstadoNotaCredito= activarnombreEstadoNotaCredito;
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
		
		
		this.setMostraridEstadoNotaCredito(esInicial);
		this.setMostrarcodigoEstadoNotaCredito(esInicial);
		this.setMostrarnombreEstadoNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.ID)) {
				this.setMostraridEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoNotaCredito(esAsigna);
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
		
		
		this.setActivaridEstadoNotaCredito(esInicial);
		this.setActivarcodigoEstadoNotaCredito(esInicial);
		this.setActivarnombreEstadoNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.ID)) {
				this.setActivaridEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoNotaCredito(esInicial);
		this.setResaltarcodigoEstadoNotaCredito(esInicial);
		this.setResaltarnombreEstadoNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.ID)) {
				this.setResaltaridEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNotaCreditoSoliEstadoNotaCredito=null;

	public Border getResaltarNotaCreditoSoliEstadoNotaCredito() {
		return this.resaltarNotaCreditoSoliEstadoNotaCredito;
	}

	public void setResaltarNotaCreditoSoliEstadoNotaCredito(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliEstadoNotaCredito= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliEstadoNotaCredito= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliEstadoNotaCredito=true;

	public Boolean getMostrarNotaCreditoSoliEstadoNotaCredito() {
		return this.mostrarNotaCreditoSoliEstadoNotaCredito;
	}

	public void setMostrarNotaCreditoSoliEstadoNotaCredito(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliEstadoNotaCredito= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliEstadoNotaCredito=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliEstadoNotaCredito() {
		return this.activarNotaCreditoSoliEstadoNotaCredito;
	}

	public void setActivarNotaCreditoSoliEstadoNotaCredito(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliEstadoNotaCredito= habilitarResaltarNotaCreditoSoli;
	}


	public Border resaltarNotaCreditoPuntoVentaEstadoNotaCredito=null;

	public Border getResaltarNotaCreditoPuntoVentaEstadoNotaCredito() {
		return this.resaltarNotaCreditoPuntoVentaEstadoNotaCredito;
	}

	public void setResaltarNotaCreditoPuntoVentaEstadoNotaCredito(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaEstadoNotaCredito= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaEstadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadonotacreditoBeanSwingJInternalFrame.jTtoolBarEstadoNotaCredito.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaEstadoNotaCredito= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaEstadoNotaCredito=true;

	public Boolean getMostrarNotaCreditoPuntoVentaEstadoNotaCredito() {
		return this.mostrarNotaCreditoPuntoVentaEstadoNotaCredito;
	}

	public void setMostrarNotaCreditoPuntoVentaEstadoNotaCredito(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaEstadoNotaCredito= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaEstadoNotaCredito=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaEstadoNotaCredito() {
		return this.activarNotaCreditoPuntoVentaEstadoNotaCredito;
	}

	public void setActivarNotaCreditoPuntoVentaEstadoNotaCredito(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaEstadoNotaCredito= habilitarResaltarNotaCreditoPuntoVenta;
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

		this.setMostrarNotaCreditoSoliEstadoNotaCredito(esInicial);
		this.setMostrarNotaCreditoPuntoVentaEstadoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliEstadoNotaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaEstadoNotaCredito(esAsigna);
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

		this.setActivarNotaCreditoSoliEstadoNotaCredito(esInicial);
		this.setActivarNotaCreditoPuntoVentaEstadoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliEstadoNotaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaEstadoNotaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNotaCreditoBeanSwingJInternalFrame estadonotacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNotaCreditoSoliEstadoNotaCredito(esInicial);
		this.setResaltarNotaCreditoPuntoVentaEstadoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliEstadoNotaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaEstadoNotaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}