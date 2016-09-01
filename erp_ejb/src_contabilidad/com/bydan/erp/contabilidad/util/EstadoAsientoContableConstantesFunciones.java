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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.EstadoAsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.EstadoAsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EstadoAsientoContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoAsientoContableConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoAsientoContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoAsientoContable"+EstadoAsientoContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoAsientoContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoAsientoContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoAsientoContableConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoAsientoContableConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoAsientoContableConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoAsientoContableConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoAsientoContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoAsientoContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoAsientoContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoAsientoContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Asiento Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Asiento Contable";
	public static final String SCLASSWEBTITULO_LOWER="Estado Asiento Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoAsientoContable";
	public static final String OBJECTNAME="estadoasientocontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="estado_asiento_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoasientocontable from "+EstadoAsientoContableConstantesFunciones.SPERSISTENCENAME+" estadoasientocontable";
	public static String QUERYSELECTNATIVE="select "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".codigo,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".nombre,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".id_color_general from "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDCOLORGENERAL= "id_color_general";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDCOLORGENERAL= "Color General";
		public static final String LABEL_IDCOLORGENERAL_LOWER= "Color General";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoAsientoContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoAsientoContableConstantesFunciones.CODIGO)) {sLabelColumna=EstadoAsientoContableConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoAsientoContableConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoAsientoContableConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL)) {sLabelColumna=EstadoAsientoContableConstantesFunciones.LABEL_IDCOLORGENERAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getEstadoAsientoContableDescripcion(EstadoAsientoContable estadoasientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoasientocontable !=null/* && estadoasientocontable.getId()!=0*/) {
			sDescripcion=estadoasientocontable.getcodigo();//estadoasientocontableestadoasientocontable.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoAsientoContableDescripcionDetallado(EstadoAsientoContable estadoasientocontable) {
		String sDescripcion="";
			
		sDescripcion+=EstadoAsientoContableConstantesFunciones.ID+"=";
		sDescripcion+=estadoasientocontable.getId().toString()+",";
		sDescripcion+=EstadoAsientoContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoasientocontable.getVersionRow().toString()+",";
		sDescripcion+=EstadoAsientoContableConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoasientocontable.getcodigo()+",";
		sDescripcion+=EstadoAsientoContableConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoasientocontable.getnombre()+",";
		sDescripcion+=EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL+"=";
		sDescripcion+=estadoasientocontable.getid_color_general().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoAsientoContableDescripcion(EstadoAsientoContable estadoasientocontable,String sValor) throws Exception {			
		if(estadoasientocontable !=null) {
			estadoasientocontable.setcodigo(sValor);;//estadoasientocontableestadoasientocontable.getcodigo().trim();
		}		
	}
	
		

	public static String getColorGeneralDescripcion(ColorGeneral colorgeneral) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(colorgeneral!=null/*&&colorgeneral.getId()>0*/) {
			sDescripcion=ColorGeneralConstantesFunciones.getColorGeneralDescripcion(colorgeneral);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdColorGeneral")) {
			sNombreIndice="Tipo=  Por Color General";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdColorGeneral(Long id_color_general) {
		String sDetalleIndice=" Parametros->";
		if(id_color_general!=null) {sDetalleIndice+=" Codigo Unico De Color General="+id_color_general.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoAsientoContable(EstadoAsientoContable estadoasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoasientocontable.setcodigo(estadoasientocontable.getcodigo().trim());
		estadoasientocontable.setnombre(estadoasientocontable.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoAsientoContables(List<EstadoAsientoContable> estadoasientocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoAsientoContable estadoasientocontable: estadoasientocontables) {
			estadoasientocontable.setcodigo(estadoasientocontable.getcodigo().trim());
			estadoasientocontable.setnombre(estadoasientocontable.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAsientoContable(EstadoAsientoContable estadoasientocontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoasientocontable.getConCambioAuxiliar()) {
			estadoasientocontable.setIsDeleted(estadoasientocontable.getIsDeletedAuxiliar());	
			estadoasientocontable.setIsNew(estadoasientocontable.getIsNewAuxiliar());	
			estadoasientocontable.setIsChanged(estadoasientocontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoasientocontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoasientocontable.setIsDeletedAuxiliar(false);	
			estadoasientocontable.setIsNewAuxiliar(false);	
			estadoasientocontable.setIsChangedAuxiliar(false);
			
			estadoasientocontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAsientoContables(List<EstadoAsientoContable> estadoasientocontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoAsientoContable estadoasientocontable : estadoasientocontables) {
			if(conAsignarBase && estadoasientocontable.getConCambioAuxiliar()) {
				estadoasientocontable.setIsDeleted(estadoasientocontable.getIsDeletedAuxiliar());	
				estadoasientocontable.setIsNew(estadoasientocontable.getIsNewAuxiliar());	
				estadoasientocontable.setIsChanged(estadoasientocontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoasientocontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoasientocontable.setIsDeletedAuxiliar(false);	
				estadoasientocontable.setIsNewAuxiliar(false);	
				estadoasientocontable.setIsChangedAuxiliar(false);
				
				estadoasientocontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoAsientoContable(EstadoAsientoContable estadoasientocontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoAsientoContables(List<EstadoAsientoContable> estadoasientocontables,Boolean conEnteros) throws Exception  {
		
		for(EstadoAsientoContable estadoasientocontable: estadoasientocontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoAsientoContable(List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContable estadoasientocontableAux) throws Exception  {
		EstadoAsientoContableConstantesFunciones.InicializarValoresEstadoAsientoContable(estadoasientocontableAux,true);
		
		for(EstadoAsientoContable estadoasientocontable: estadoasientocontables) {
			if(estadoasientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoAsientoContableConstantesFunciones.getArrayColumnasGlobalesEstadoAsientoContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContable estadoasientocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoAsientoContable estadoasientocontableAux: estadoasientocontables) {
			if(estadoasientocontableAux!=null && estadoasientocontable!=null) {
				if((estadoasientocontableAux.getId()==null && estadoasientocontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoasientocontableAux.getId()!=null && estadoasientocontable.getId()!=null){
					if(estadoasientocontableAux.getId().equals(estadoasientocontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoAsientoContable(List<EstadoAsientoContable> estadoasientocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoAsientoContable estadoasientocontable: estadoasientocontables) {			
			if(estadoasientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoAsientoContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoAsientoContableConstantesFunciones.LABEL_ID, EstadoAsientoContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableConstantesFunciones.LABEL_VERSIONROW, EstadoAsientoContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableConstantesFunciones.LABEL_CODIGO, EstadoAsientoContableConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableConstantesFunciones.LABEL_NOMBRE, EstadoAsientoContableConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableConstantesFunciones.LABEL_IDCOLORGENERAL, EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoAsientoContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContable() throws Exception  {
		return EstadoAsientoContableConstantesFunciones.getTiposSeleccionarEstadoAsientoContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContable(Boolean conFk) throws Exception  {
		return EstadoAsientoContableConstantesFunciones.getTiposSeleccionarEstadoAsientoContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAsientoContableConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoAsientoContableConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAsientoContableConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoAsientoContableConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAsientoContableConstantesFunciones.LABEL_IDCOLORGENERAL);
			reporte.setsDescripcion(EstadoAsientoContableConstantesFunciones.LABEL_IDCOLORGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoAsientoContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAsientoContable(EstadoAsientoContable estadoasientocontableAux) throws Exception {
		
			estadoasientocontableAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadoasientocontableAux.getColorGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAsientoContable(List<EstadoAsientoContable> estadoasientocontablesTemp) throws Exception {
		for(EstadoAsientoContable estadoasientocontableAux:estadoasientocontablesTemp) {
			
			estadoasientocontableAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadoasientocontableAux.getColorGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ColorGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorGeneral.class)) {
						classes.add(new Classe(ColorGeneral.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorGeneral.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAsientoContableConstantesFunciones.getClassesRelationshipsOfEstadoAsientoContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroContabilidadDefecto.class));
				classes.add(new Classe(AsientoContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroContabilidadDefecto.class)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAsientoContableConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoAsientoContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	public static void actualizarLista(EstadoAsientoContable estadoasientocontable,List<EstadoAsientoContable> estadoasientocontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoAsientoContable estadoasientocontableEncontrado=null;
			
			for(EstadoAsientoContable estadoasientocontableLocal:estadoasientocontables) {
				if(estadoasientocontableLocal.getId().equals(estadoasientocontable.getId())) {
					estadoasientocontableEncontrado=estadoasientocontableLocal;
					
					estadoasientocontableLocal.setIsChanged(estadoasientocontable.getIsChanged());
					estadoasientocontableLocal.setIsNew(estadoasientocontable.getIsNew());
					estadoasientocontableLocal.setIsDeleted(estadoasientocontable.getIsDeleted());
					
					estadoasientocontableLocal.setGeneralEntityOriginal(estadoasientocontable.getGeneralEntityOriginal());
					
					estadoasientocontableLocal.setId(estadoasientocontable.getId());	
					estadoasientocontableLocal.setVersionRow(estadoasientocontable.getVersionRow());	
					estadoasientocontableLocal.setcodigo(estadoasientocontable.getcodigo());	
					estadoasientocontableLocal.setnombre(estadoasientocontable.getnombre());	
					estadoasientocontableLocal.setid_color_general(estadoasientocontable.getid_color_general());	
					
					
					estadoasientocontableLocal.setParametroContabilidadDefectos(estadoasientocontable.getParametroContabilidadDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoasientocontable.getIsDeleted()) {
				if(!existe) {
					estadoasientocontables.add(estadoasientocontable);
				}
			} else {
				if(estadoasientocontableEncontrado!=null && permiteQuitar)  {
					estadoasientocontables.remove(estadoasientocontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoAsientoContable estadoasientocontable,List<EstadoAsientoContable> estadoasientocontables) throws Exception {
		try	{			
			for(EstadoAsientoContable estadoasientocontableLocal:estadoasientocontables) {
				if(estadoasientocontableLocal.getId().equals(estadoasientocontable.getId())) {
					estadoasientocontableLocal.setIsSelected(estadoasientocontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoAsientoContable(List<EstadoAsientoContable> estadoasientocontablesAux) throws Exception {
		//this.estadoasientocontablesAux=estadoasientocontablesAux;
		
		for(EstadoAsientoContable estadoasientocontableAux:estadoasientocontablesAux) {
			if(estadoasientocontableAux.getIsChanged()) {
				estadoasientocontableAux.setIsChanged(false);
			}		
			
			if(estadoasientocontableAux.getIsNew()) {
				estadoasientocontableAux.setIsNew(false);
			}	
			
			if(estadoasientocontableAux.getIsDeleted()) {
				estadoasientocontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoAsientoContable(EstadoAsientoContable estadoasientocontableAux) throws Exception {
		//this.estadoasientocontableAux=estadoasientocontableAux;
		
			if(estadoasientocontableAux.getIsChanged()) {
				estadoasientocontableAux.setIsChanged(false);
			}		
			
			if(estadoasientocontableAux.getIsNew()) {
				estadoasientocontableAux.setIsNew(false);
			}	
			
			if(estadoasientocontableAux.getIsDeleted()) {
				estadoasientocontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoAsientoContable estadoasientocontableAsignar,EstadoAsientoContable estadoasientocontable) throws Exception {
		estadoasientocontableAsignar.setId(estadoasientocontable.getId());	
		estadoasientocontableAsignar.setVersionRow(estadoasientocontable.getVersionRow());	
		estadoasientocontableAsignar.setcodigo(estadoasientocontable.getcodigo());	
		estadoasientocontableAsignar.setnombre(estadoasientocontable.getnombre());	
		estadoasientocontableAsignar.setid_color_general(estadoasientocontable.getid_color_general());
		estadoasientocontableAsignar.setcolorgeneral_descripcion(estadoasientocontable.getcolorgeneral_descripcion());	
	}
	
	public static void inicializarEstadoAsientoContable(EstadoAsientoContable estadoasientocontable) throws Exception {
		try {
				estadoasientocontable.setId(0L);	
					
				estadoasientocontable.setcodigo("");	
				estadoasientocontable.setnombre("");	
				estadoasientocontable.setid_color_general(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoAsientoContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAsientoContableConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAsientoContableConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAsientoContableConstantesFunciones.LABEL_IDCOLORGENERAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoAsientoContable(String sTipo,Row row,Workbook workbook,EstadoAsientoContable estadoasientocontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoasientocontable.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoasientocontable.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoasientocontable.getcolorgeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoAsientoContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoAsientoContable() {
		return this.sFinalQueryEstadoAsientoContable;
	}
	
	public void setsFinalQueryEstadoAsientoContable(String sFinalQueryEstadoAsientoContable) {
		this.sFinalQueryEstadoAsientoContable= sFinalQueryEstadoAsientoContable;
	}
	
	public Border resaltarSeleccionarEstadoAsientoContable=null;
	
	public Border setResaltarSeleccionarEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoAsientoContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoAsientoContable() {
		return this.resaltarSeleccionarEstadoAsientoContable;
	}
	
	public void setResaltarSeleccionarEstadoAsientoContable(Border borderResaltarSeleccionarEstadoAsientoContable) {
		this.resaltarSeleccionarEstadoAsientoContable= borderResaltarSeleccionarEstadoAsientoContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoAsientoContable=null;
	public Boolean mostraridEstadoAsientoContable=true;
	public Boolean activaridEstadoAsientoContable=true;

	public Border resaltarcodigoEstadoAsientoContable=null;
	public Boolean mostrarcodigoEstadoAsientoContable=true;
	public Boolean activarcodigoEstadoAsientoContable=true;

	public Border resaltarnombreEstadoAsientoContable=null;
	public Boolean mostrarnombreEstadoAsientoContable=true;
	public Boolean activarnombreEstadoAsientoContable=true;

	public Border resaltarid_color_generalEstadoAsientoContable=null;
	public Boolean mostrarid_color_generalEstadoAsientoContable=true;
	public Boolean activarid_color_generalEstadoAsientoContable=true;
	public Boolean cargarid_color_generalEstadoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_color_generalEstadoAsientoContable=false;//ConEventDepend=true

	
	

	public Border setResaltaridEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltar);
		
		this.resaltaridEstadoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoAsientoContable() {
		return this.resaltaridEstadoAsientoContable;
	}

	public void setResaltaridEstadoAsientoContable(Border borderResaltar) {
		this.resaltaridEstadoAsientoContable= borderResaltar;
	}

	public Boolean getMostraridEstadoAsientoContable() {
		return this.mostraridEstadoAsientoContable;
	}

	public void setMostraridEstadoAsientoContable(Boolean mostraridEstadoAsientoContable) {
		this.mostraridEstadoAsientoContable= mostraridEstadoAsientoContable;
	}

	public Boolean getActivaridEstadoAsientoContable() {
		return this.activaridEstadoAsientoContable;
	}

	public void setActivaridEstadoAsientoContable(Boolean activaridEstadoAsientoContable) {
		this.activaridEstadoAsientoContable= activaridEstadoAsientoContable;
	}

	public Border setResaltarcodigoEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoAsientoContable() {
		return this.resaltarcodigoEstadoAsientoContable;
	}

	public void setResaltarcodigoEstadoAsientoContable(Border borderResaltar) {
		this.resaltarcodigoEstadoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoAsientoContable() {
		return this.mostrarcodigoEstadoAsientoContable;
	}

	public void setMostrarcodigoEstadoAsientoContable(Boolean mostrarcodigoEstadoAsientoContable) {
		this.mostrarcodigoEstadoAsientoContable= mostrarcodigoEstadoAsientoContable;
	}

	public Boolean getActivarcodigoEstadoAsientoContable() {
		return this.activarcodigoEstadoAsientoContable;
	}

	public void setActivarcodigoEstadoAsientoContable(Boolean activarcodigoEstadoAsientoContable) {
		this.activarcodigoEstadoAsientoContable= activarcodigoEstadoAsientoContable;
	}

	public Border setResaltarnombreEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoAsientoContable() {
		return this.resaltarnombreEstadoAsientoContable;
	}

	public void setResaltarnombreEstadoAsientoContable(Border borderResaltar) {
		this.resaltarnombreEstadoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoAsientoContable() {
		return this.mostrarnombreEstadoAsientoContable;
	}

	public void setMostrarnombreEstadoAsientoContable(Boolean mostrarnombreEstadoAsientoContable) {
		this.mostrarnombreEstadoAsientoContable= mostrarnombreEstadoAsientoContable;
	}

	public Boolean getActivarnombreEstadoAsientoContable() {
		return this.activarnombreEstadoAsientoContable;
	}

	public void setActivarnombreEstadoAsientoContable(Boolean activarnombreEstadoAsientoContable) {
		this.activarnombreEstadoAsientoContable= activarnombreEstadoAsientoContable;
	}

	public Border setResaltarid_color_generalEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_color_generalEstadoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_color_generalEstadoAsientoContable() {
		return this.resaltarid_color_generalEstadoAsientoContable;
	}

	public void setResaltarid_color_generalEstadoAsientoContable(Border borderResaltar) {
		this.resaltarid_color_generalEstadoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_color_generalEstadoAsientoContable() {
		return this.mostrarid_color_generalEstadoAsientoContable;
	}

	public void setMostrarid_color_generalEstadoAsientoContable(Boolean mostrarid_color_generalEstadoAsientoContable) {
		this.mostrarid_color_generalEstadoAsientoContable= mostrarid_color_generalEstadoAsientoContable;
	}

	public Boolean getActivarid_color_generalEstadoAsientoContable() {
		return this.activarid_color_generalEstadoAsientoContable;
	}

	public void setActivarid_color_generalEstadoAsientoContable(Boolean activarid_color_generalEstadoAsientoContable) {
		this.activarid_color_generalEstadoAsientoContable= activarid_color_generalEstadoAsientoContable;
	}

	public Boolean getCargarid_color_generalEstadoAsientoContable() {
		return this.cargarid_color_generalEstadoAsientoContable;
	}

	public void setCargarid_color_generalEstadoAsientoContable(Boolean cargarid_color_generalEstadoAsientoContable) {
		this.cargarid_color_generalEstadoAsientoContable= cargarid_color_generalEstadoAsientoContable;
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
		
		
		this.setMostraridEstadoAsientoContable(esInicial);
		this.setMostrarcodigoEstadoAsientoContable(esInicial);
		this.setMostrarnombreEstadoAsientoContable(esInicial);
		this.setMostrarid_color_generalEstadoAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.ID)) {
				this.setMostraridEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL)) {
				this.setMostrarid_color_generalEstadoAsientoContable(esAsigna);
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
		
		
		this.setActivaridEstadoAsientoContable(esInicial);
		this.setActivarcodigoEstadoAsientoContable(esInicial);
		this.setActivarnombreEstadoAsientoContable(esInicial);
		this.setActivarid_color_generalEstadoAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.ID)) {
				this.setActivaridEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL)) {
				this.setActivarid_color_generalEstadoAsientoContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoAsientoContable(esInicial);
		this.setResaltarcodigoEstadoAsientoContable(esInicial);
		this.setResaltarnombreEstadoAsientoContable(esInicial);
		this.setResaltarid_color_generalEstadoAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.ID)) {
				this.setResaltaridEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL)) {
				this.setResaltarid_color_generalEstadoAsientoContable(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroContabilidadDefectoEstadoAsientoContable=null;

	public Border getResaltarParametroContabilidadDefectoEstadoAsientoContable() {
		return this.resaltarParametroContabilidadDefectoEstadoAsientoContable;
	}

	public void setResaltarParametroContabilidadDefectoEstadoAsientoContable(Border borderResaltarParametroContabilidadDefecto) {
		if(borderResaltarParametroContabilidadDefecto!=null) {
			this.resaltarParametroContabilidadDefectoEstadoAsientoContable= borderResaltarParametroContabilidadDefecto;
		}
	}

	public Border setResaltarParametroContabilidadDefectoEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroContabilidadDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoasientocontableBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContable.setBorder(borderResaltarParametroContabilidadDefecto);
			
		this.resaltarParametroContabilidadDefectoEstadoAsientoContable= borderResaltarParametroContabilidadDefecto;

		 return borderResaltarParametroContabilidadDefecto;
	}



	public Boolean mostrarParametroContabilidadDefectoEstadoAsientoContable=true;

	public Boolean getMostrarParametroContabilidadDefectoEstadoAsientoContable() {
		return this.mostrarParametroContabilidadDefectoEstadoAsientoContable;
	}

	public void setMostrarParametroContabilidadDefectoEstadoAsientoContable(Boolean visibilidadResaltarParametroContabilidadDefecto) {
		this.mostrarParametroContabilidadDefectoEstadoAsientoContable= visibilidadResaltarParametroContabilidadDefecto;
	}



	public Boolean activarParametroContabilidadDefectoEstadoAsientoContable=true;

	public Boolean gethabilitarResaltarParametroContabilidadDefectoEstadoAsientoContable() {
		return this.activarParametroContabilidadDefectoEstadoAsientoContable;
	}

	public void setActivarParametroContabilidadDefectoEstadoAsientoContable(Boolean habilitarResaltarParametroContabilidadDefecto) {
		this.activarParametroContabilidadDefectoEstadoAsientoContable= habilitarResaltarParametroContabilidadDefecto;
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

		this.setMostrarParametroContabilidadDefectoEstadoAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setMostrarParametroContabilidadDefectoEstadoAsientoContable(esAsigna);
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

		this.setActivarParametroContabilidadDefectoEstadoAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setActivarParametroContabilidadDefectoEstadoAsientoContable(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroContabilidadDefectoEstadoAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setResaltarParametroContabilidadDefectoEstadoAsientoContable(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdColorGeneralEstadoAsientoContable=true;

	public Boolean getMostrarFK_IdColorGeneralEstadoAsientoContable() {
		return this.mostrarFK_IdColorGeneralEstadoAsientoContable;
	}

	public void setMostrarFK_IdColorGeneralEstadoAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdColorGeneralEstadoAsientoContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdColorGeneralEstadoAsientoContable=true;

	public Boolean getActivarFK_IdColorGeneralEstadoAsientoContable() {
		return this.activarFK_IdColorGeneralEstadoAsientoContable;
	}

	public void setActivarFK_IdColorGeneralEstadoAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdColorGeneralEstadoAsientoContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdColorGeneralEstadoAsientoContable=null;

	public Border getResaltarFK_IdColorGeneralEstadoAsientoContable() {
		return this.resaltarFK_IdColorGeneralEstadoAsientoContable;
	}

	public void setResaltarFK_IdColorGeneralEstadoAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdColorGeneralEstadoAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdColorGeneralEstadoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableBeanSwingJInternalFrame estadoasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdColorGeneralEstadoAsientoContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}