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


import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoAsientoContableCajaChicaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoAsientoContableCajaChica";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoAsientoContableCajaChica"+EstadoAsientoContableCajaChicaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoAsientoContableCajaChicaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoAsientoContableCajaChicaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoAsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoAsientoContableCajaChicaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoAsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoAsientoContableCajaChicaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Asiento Contable Caja Chicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Asiento Contable Caja Chica";
	public static final String SCLASSWEBTITULO_LOWER="Estado Asiento Contable Caja Chica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoAsientoContableCajaChica";
	public static final String OBJECTNAME="estadoasientocontablecajachica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="estado_asiento_contable_caja_chica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoasientocontablecajachica from "+EstadoAsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" estadoasientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".codigo,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".nombre from "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoAsientoContableCajaChicaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO)) {sLabelColumna=EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoAsientoContableCajaChicaDescripcion(EstadoAsientoContableCajaChica estadoasientocontablecajachica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoasientocontablecajachica !=null/* && estadoasientocontablecajachica.getId()!=0*/) {
			sDescripcion=estadoasientocontablecajachica.getcodigo();//estadoasientocontablecajachicaestadoasientocontablecajachica.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoAsientoContableCajaChicaDescripcionDetallado(EstadoAsientoContableCajaChica estadoasientocontablecajachica) {
		String sDescripcion="";
			
		sDescripcion+=EstadoAsientoContableCajaChicaConstantesFunciones.ID+"=";
		sDescripcion+=estadoasientocontablecajachica.getId().toString()+",";
		sDescripcion+=EstadoAsientoContableCajaChicaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoasientocontablecajachica.getVersionRow().toString()+",";
		sDescripcion+=EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoasientocontablecajachica.getcodigo()+",";
		sDescripcion+=EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoasientocontablecajachica.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoAsientoContableCajaChicaDescripcion(EstadoAsientoContableCajaChica estadoasientocontablecajachica,String sValor) throws Exception {			
		if(estadoasientocontablecajachica !=null) {
			estadoasientocontablecajachica.setcodigo(sValor);;//estadoasientocontablecajachicaestadoasientocontablecajachica.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoasientocontablecajachica.setcodigo(estadoasientocontablecajachica.getcodigo().trim());
		estadoasientocontablecajachica.setnombre(estadoasientocontablecajachica.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoAsientoContableCajaChicas(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica: estadoasientocontablecajachicas) {
			estadoasientocontablecajachica.setcodigo(estadoasientocontablecajachica.getcodigo().trim());
			estadoasientocontablecajachica.setnombre(estadoasientocontablecajachica.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoasientocontablecajachica.getConCambioAuxiliar()) {
			estadoasientocontablecajachica.setIsDeleted(estadoasientocontablecajachica.getIsDeletedAuxiliar());	
			estadoasientocontablecajachica.setIsNew(estadoasientocontablecajachica.getIsNewAuxiliar());	
			estadoasientocontablecajachica.setIsChanged(estadoasientocontablecajachica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoasientocontablecajachica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoasientocontablecajachica.setIsDeletedAuxiliar(false);	
			estadoasientocontablecajachica.setIsNewAuxiliar(false);	
			estadoasientocontablecajachica.setIsChangedAuxiliar(false);
			
			estadoasientocontablecajachica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAsientoContableCajaChicas(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica : estadoasientocontablecajachicas) {
			if(conAsignarBase && estadoasientocontablecajachica.getConCambioAuxiliar()) {
				estadoasientocontablecajachica.setIsDeleted(estadoasientocontablecajachica.getIsDeletedAuxiliar());	
				estadoasientocontablecajachica.setIsNew(estadoasientocontablecajachica.getIsNewAuxiliar());	
				estadoasientocontablecajachica.setIsChanged(estadoasientocontablecajachica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoasientocontablecajachica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoasientocontablecajachica.setIsDeletedAuxiliar(false);	
				estadoasientocontablecajachica.setIsNewAuxiliar(false);	
				estadoasientocontablecajachica.setIsChangedAuxiliar(false);
				
				estadoasientocontablecajachica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoAsientoContableCajaChicas(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,Boolean conEnteros) throws Exception  {
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica: estadoasientocontablecajachicas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux) throws Exception  {
		EstadoAsientoContableCajaChicaConstantesFunciones.InicializarValoresEstadoAsientoContableCajaChica(estadoasientocontablecajachicaAux,true);
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica: estadoasientocontablecajachicas) {
			if(estadoasientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoAsientoContableCajaChicaConstantesFunciones.getArrayColumnasGlobalesEstadoAsientoContableCajaChica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChica estadoasientocontablecajachica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux: estadoasientocontablecajachicas) {
			if(estadoasientocontablecajachicaAux!=null && estadoasientocontablecajachica!=null) {
				if((estadoasientocontablecajachicaAux.getId()==null && estadoasientocontablecajachica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoasientocontablecajachicaAux.getId()!=null && estadoasientocontablecajachica.getId()!=null){
					if(estadoasientocontablecajachicaAux.getId().equals(estadoasientocontablecajachica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica: estadoasientocontablecajachicas) {			
			if(estadoasientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoAsientoContableCajaChica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_ID, EstadoAsientoContableCajaChicaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_VERSIONROW, EstadoAsientoContableCajaChicaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_CODIGO, EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_NOMBRE, EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoAsientoContableCajaChica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableCajaChicaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableCajaChicaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContableCajaChica() throws Exception  {
		return EstadoAsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarEstadoAsientoContableCajaChica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContableCajaChica(Boolean conFk) throws Exception  {
		return EstadoAsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarEstadoAsientoContableCajaChica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAsientoContableCajaChica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoAsientoContableCajaChica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasTemp) throws Exception {
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux:estadoasientocontablecajachicasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfEstadoAsientoContableCajaChica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AsientoContableCajaChica.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContableCajaChica.class)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoAsientoContableCajaChica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
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
	public static void actualizarLista(EstadoAsientoContableCajaChica estadoasientocontablecajachica,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoAsientoContableCajaChica estadoasientocontablecajachicaEncontrado=null;
			
			for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal:estadoasientocontablecajachicas) {
				if(estadoasientocontablecajachicaLocal.getId().equals(estadoasientocontablecajachica.getId())) {
					estadoasientocontablecajachicaEncontrado=estadoasientocontablecajachicaLocal;
					
					estadoasientocontablecajachicaLocal.setIsChanged(estadoasientocontablecajachica.getIsChanged());
					estadoasientocontablecajachicaLocal.setIsNew(estadoasientocontablecajachica.getIsNew());
					estadoasientocontablecajachicaLocal.setIsDeleted(estadoasientocontablecajachica.getIsDeleted());
					
					estadoasientocontablecajachicaLocal.setGeneralEntityOriginal(estadoasientocontablecajachica.getGeneralEntityOriginal());
					
					estadoasientocontablecajachicaLocal.setId(estadoasientocontablecajachica.getId());	
					estadoasientocontablecajachicaLocal.setVersionRow(estadoasientocontablecajachica.getVersionRow());	
					estadoasientocontablecajachicaLocal.setcodigo(estadoasientocontablecajachica.getcodigo());	
					estadoasientocontablecajachicaLocal.setnombre(estadoasientocontablecajachica.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadoasientocontablecajachica.getIsDeleted()) {
				if(!existe) {
					estadoasientocontablecajachicas.add(estadoasientocontablecajachica);
				}
			} else {
				if(estadoasientocontablecajachicaEncontrado!=null && permiteQuitar)  {
					estadoasientocontablecajachicas.remove(estadoasientocontablecajachicaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoAsientoContableCajaChica estadoasientocontablecajachica,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas) throws Exception {
		try	{			
			for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal:estadoasientocontablecajachicas) {
				if(estadoasientocontablecajachicaLocal.getId().equals(estadoasientocontablecajachica.getId())) {
					estadoasientocontablecajachicaLocal.setIsSelected(estadoasientocontablecajachica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasAux) throws Exception {
		//this.estadoasientocontablecajachicasAux=estadoasientocontablecajachicasAux;
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux:estadoasientocontablecajachicasAux) {
			if(estadoasientocontablecajachicaAux.getIsChanged()) {
				estadoasientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(estadoasientocontablecajachicaAux.getIsNew()) {
				estadoasientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(estadoasientocontablecajachicaAux.getIsDeleted()) {
				estadoasientocontablecajachicaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux) throws Exception {
		//this.estadoasientocontablecajachicaAux=estadoasientocontablecajachicaAux;
		
			if(estadoasientocontablecajachicaAux.getIsChanged()) {
				estadoasientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(estadoasientocontablecajachicaAux.getIsNew()) {
				estadoasientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(estadoasientocontablecajachicaAux.getIsDeleted()) {
				estadoasientocontablecajachicaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAsignar,EstadoAsientoContableCajaChica estadoasientocontablecajachica) throws Exception {
		estadoasientocontablecajachicaAsignar.setId(estadoasientocontablecajachica.getId());	
		estadoasientocontablecajachicaAsignar.setVersionRow(estadoasientocontablecajachica.getVersionRow());	
		estadoasientocontablecajachicaAsignar.setcodigo(estadoasientocontablecajachica.getcodigo());	
		estadoasientocontablecajachicaAsignar.setnombre(estadoasientocontablecajachica.getnombre());	
	}
	
	public static void inicializarEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica) throws Exception {
		try {
				estadoasientocontablecajachica.setId(0L);	
					
				estadoasientocontablecajachica.setcodigo("");	
				estadoasientocontablecajachica.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoAsientoContableCajaChica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAsientoContableCajaChicaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoAsientoContableCajaChica(String sTipo,Row row,Workbook workbook,EstadoAsientoContableCajaChica estadoasientocontablecajachica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoasientocontablecajachica.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoasientocontablecajachica.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoAsientoContableCajaChica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoAsientoContableCajaChica() {
		return this.sFinalQueryEstadoAsientoContableCajaChica;
	}
	
	public void setsFinalQueryEstadoAsientoContableCajaChica(String sFinalQueryEstadoAsientoContableCajaChica) {
		this.sFinalQueryEstadoAsientoContableCajaChica= sFinalQueryEstadoAsientoContableCajaChica;
	}
	
	public Border resaltarSeleccionarEstadoAsientoContableCajaChica=null;
	
	public Border setResaltarSeleccionarEstadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoAsientoContableCajaChica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoAsientoContableCajaChica() {
		return this.resaltarSeleccionarEstadoAsientoContableCajaChica;
	}
	
	public void setResaltarSeleccionarEstadoAsientoContableCajaChica(Border borderResaltarSeleccionarEstadoAsientoContableCajaChica) {
		this.resaltarSeleccionarEstadoAsientoContableCajaChica= borderResaltarSeleccionarEstadoAsientoContableCajaChica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoAsientoContableCajaChica=null;
	public Boolean mostraridEstadoAsientoContableCajaChica=true;
	public Boolean activaridEstadoAsientoContableCajaChica=true;

	public Border resaltarcodigoEstadoAsientoContableCajaChica=null;
	public Boolean mostrarcodigoEstadoAsientoContableCajaChica=true;
	public Boolean activarcodigoEstadoAsientoContableCajaChica=true;

	public Border resaltarnombreEstadoAsientoContableCajaChica=null;
	public Boolean mostrarnombreEstadoAsientoContableCajaChica=true;
	public Boolean activarnombreEstadoAsientoContableCajaChica=true;

	
	

	public Border setResaltaridEstadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltaridEstadoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoAsientoContableCajaChica() {
		return this.resaltaridEstadoAsientoContableCajaChica;
	}

	public void setResaltaridEstadoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltaridEstadoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostraridEstadoAsientoContableCajaChica() {
		return this.mostraridEstadoAsientoContableCajaChica;
	}

	public void setMostraridEstadoAsientoContableCajaChica(Boolean mostraridEstadoAsientoContableCajaChica) {
		this.mostraridEstadoAsientoContableCajaChica= mostraridEstadoAsientoContableCajaChica;
	}

	public Boolean getActivaridEstadoAsientoContableCajaChica() {
		return this.activaridEstadoAsientoContableCajaChica;
	}

	public void setActivaridEstadoAsientoContableCajaChica(Boolean activaridEstadoAsientoContableCajaChica) {
		this.activaridEstadoAsientoContableCajaChica= activaridEstadoAsientoContableCajaChica;
	}

	public Border setResaltarcodigoEstadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoAsientoContableCajaChica() {
		return this.resaltarcodigoEstadoAsientoContableCajaChica;
	}

	public void setResaltarcodigoEstadoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarcodigoEstadoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoAsientoContableCajaChica() {
		return this.mostrarcodigoEstadoAsientoContableCajaChica;
	}

	public void setMostrarcodigoEstadoAsientoContableCajaChica(Boolean mostrarcodigoEstadoAsientoContableCajaChica) {
		this.mostrarcodigoEstadoAsientoContableCajaChica= mostrarcodigoEstadoAsientoContableCajaChica;
	}

	public Boolean getActivarcodigoEstadoAsientoContableCajaChica() {
		return this.activarcodigoEstadoAsientoContableCajaChica;
	}

	public void setActivarcodigoEstadoAsientoContableCajaChica(Boolean activarcodigoEstadoAsientoContableCajaChica) {
		this.activarcodigoEstadoAsientoContableCajaChica= activarcodigoEstadoAsientoContableCajaChica;
	}

	public Border setResaltarnombreEstadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarEstadoAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoAsientoContableCajaChica() {
		return this.resaltarnombreEstadoAsientoContableCajaChica;
	}

	public void setResaltarnombreEstadoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarnombreEstadoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoAsientoContableCajaChica() {
		return this.mostrarnombreEstadoAsientoContableCajaChica;
	}

	public void setMostrarnombreEstadoAsientoContableCajaChica(Boolean mostrarnombreEstadoAsientoContableCajaChica) {
		this.mostrarnombreEstadoAsientoContableCajaChica= mostrarnombreEstadoAsientoContableCajaChica;
	}

	public Boolean getActivarnombreEstadoAsientoContableCajaChica() {
		return this.activarnombreEstadoAsientoContableCajaChica;
	}

	public void setActivarnombreEstadoAsientoContableCajaChica(Boolean activarnombreEstadoAsientoContableCajaChica) {
		this.activarnombreEstadoAsientoContableCajaChica= activarnombreEstadoAsientoContableCajaChica;
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
		
		
		this.setMostraridEstadoAsientoContableCajaChica(esInicial);
		this.setMostrarcodigoEstadoAsientoContableCajaChica(esInicial);
		this.setMostrarnombreEstadoAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setMostraridEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoAsientoContableCajaChica(esAsigna);
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
		
		
		this.setActivaridEstadoAsientoContableCajaChica(esInicial);
		this.setActivarcodigoEstadoAsientoContableCajaChica(esInicial);
		this.setActivarnombreEstadoAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setActivaridEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoAsientoContableCajaChica(esInicial);
		this.setResaltarcodigoEstadoAsientoContableCajaChica(esInicial);
		this.setResaltarnombreEstadoAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setResaltaridEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoAsientoContableCajaChica(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAsientoContableCajaChicaBeanSwingJInternalFrame estadoasientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
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