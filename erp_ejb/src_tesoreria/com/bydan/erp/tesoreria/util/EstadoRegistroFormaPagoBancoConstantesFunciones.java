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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoRegistroFormaPagoBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoRegistroFormaPagoBancoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoRegistroFormaPagoBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoRegistroFormaPagoBanco"+EstadoRegistroFormaPagoBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoRegistroFormaPagoBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoRegistroFormaPagoBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoRegistroFormaPagoBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoRegistroFormaPagoBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoRegistroFormaPagoBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoRegistroFormaPagoBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Registro Forma Pago Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Registro Forma Pago Banco";
	public static final String SCLASSWEBTITULO_LOWER="Estado Registro Forma Pago Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoRegistroFormaPagoBanco";
	public static final String OBJECTNAME="estadoregistroformapagobanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="estado_registro_forma_pago_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoregistroformapagobanco from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SPERSISTENCENAME+" estadoregistroformapagobanco";
	public static String QUERYSELECTNATIVE="select "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".codigo,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoRegistroFormaPagoBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoRegistroFormaPagoBancoDescripcion(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoregistroformapagobanco !=null/* && estadoregistroformapagobanco.getId()!=0*/) {
			sDescripcion=estadoregistroformapagobanco.getcodigo();//estadoregistroformapagobancoestadoregistroformapagobanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoRegistroFormaPagoBancoDescripcionDetallado(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) {
		String sDescripcion="";
			
		sDescripcion+=EstadoRegistroFormaPagoBancoConstantesFunciones.ID+"=";
		sDescripcion+=estadoregistroformapagobanco.getId().toString()+",";
		sDescripcion+=EstadoRegistroFormaPagoBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoregistroformapagobanco.getVersionRow().toString()+",";
		sDescripcion+=EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoregistroformapagobanco.getcodigo()+",";
		sDescripcion+=EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoregistroformapagobanco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoRegistroFormaPagoBancoDescripcion(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,String sValor) throws Exception {			
		if(estadoregistroformapagobanco !=null) {
			estadoregistroformapagobanco.setcodigo(sValor);;//estadoregistroformapagobancoestadoregistroformapagobanco.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoregistroformapagobanco.setcodigo(estadoregistroformapagobanco.getcodigo().trim());
		estadoregistroformapagobanco.setnombre(estadoregistroformapagobanco.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoRegistroFormaPagoBancos(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco: estadoregistroformapagobancos) {
			estadoregistroformapagobanco.setcodigo(estadoregistroformapagobanco.getcodigo().trim());
			estadoregistroformapagobanco.setnombre(estadoregistroformapagobanco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoregistroformapagobanco.getConCambioAuxiliar()) {
			estadoregistroformapagobanco.setIsDeleted(estadoregistroformapagobanco.getIsDeletedAuxiliar());	
			estadoregistroformapagobanco.setIsNew(estadoregistroformapagobanco.getIsNewAuxiliar());	
			estadoregistroformapagobanco.setIsChanged(estadoregistroformapagobanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoregistroformapagobanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoregistroformapagobanco.setIsDeletedAuxiliar(false);	
			estadoregistroformapagobanco.setIsNewAuxiliar(false);	
			estadoregistroformapagobanco.setIsChangedAuxiliar(false);
			
			estadoregistroformapagobanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRegistroFormaPagoBancos(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco : estadoregistroformapagobancos) {
			if(conAsignarBase && estadoregistroformapagobanco.getConCambioAuxiliar()) {
				estadoregistroformapagobanco.setIsDeleted(estadoregistroformapagobanco.getIsDeletedAuxiliar());	
				estadoregistroformapagobanco.setIsNew(estadoregistroformapagobanco.getIsNewAuxiliar());	
				estadoregistroformapagobanco.setIsChanged(estadoregistroformapagobanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoregistroformapagobanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoregistroformapagobanco.setIsDeletedAuxiliar(false);	
				estadoregistroformapagobanco.setIsNewAuxiliar(false);	
				estadoregistroformapagobanco.setIsChangedAuxiliar(false);
				
				estadoregistroformapagobanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoRegistroFormaPagoBancos(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,Boolean conEnteros) throws Exception  {
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco: estadoregistroformapagobancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux) throws Exception  {
		EstadoRegistroFormaPagoBancoConstantesFunciones.InicializarValoresEstadoRegistroFormaPagoBanco(estadoregistroformapagobancoAux,true);
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco: estadoregistroformapagobancos) {
			if(estadoregistroformapagobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoRegistroFormaPagoBancoConstantesFunciones.getArrayColumnasGlobalesEstadoRegistroFormaPagoBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux: estadoregistroformapagobancos) {
			if(estadoregistroformapagobancoAux!=null && estadoregistroformapagobanco!=null) {
				if((estadoregistroformapagobancoAux.getId()==null && estadoregistroformapagobanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoregistroformapagobancoAux.getId()!=null && estadoregistroformapagobanco.getId()!=null){
					if(estadoregistroformapagobancoAux.getId().equals(estadoregistroformapagobanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco: estadoregistroformapagobancos) {			
			if(estadoregistroformapagobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoRegistroFormaPagoBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_ID, EstadoRegistroFormaPagoBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_VERSIONROW, EstadoRegistroFormaPagoBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_CODIGO, EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBRE, EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoRegistroFormaPagoBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRegistroFormaPagoBanco() throws Exception  {
		return EstadoRegistroFormaPagoBancoConstantesFunciones.getTiposSeleccionarEstadoRegistroFormaPagoBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRegistroFormaPagoBanco(Boolean conFk) throws Exception  {
		return EstadoRegistroFormaPagoBancoConstantesFunciones.getTiposSeleccionarEstadoRegistroFormaPagoBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRegistroFormaPagoBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoRegistroFormaPagoBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosTemp) throws Exception {
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux:estadoregistroformapagobancosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsOfEstadoRegistroFormaPagoBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RegistroFormaPagoBanco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RegistroFormaPagoBanco.class)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoRegistroFormaPagoBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); continue;
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
	public static void actualizarLista(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoRegistroFormaPagoBanco estadoregistroformapagobancoEncontrado=null;
			
			for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal:estadoregistroformapagobancos) {
				if(estadoregistroformapagobancoLocal.getId().equals(estadoregistroformapagobanco.getId())) {
					estadoregistroformapagobancoEncontrado=estadoregistroformapagobancoLocal;
					
					estadoregistroformapagobancoLocal.setIsChanged(estadoregistroformapagobanco.getIsChanged());
					estadoregistroformapagobancoLocal.setIsNew(estadoregistroformapagobanco.getIsNew());
					estadoregistroformapagobancoLocal.setIsDeleted(estadoregistroformapagobanco.getIsDeleted());
					
					estadoregistroformapagobancoLocal.setGeneralEntityOriginal(estadoregistroformapagobanco.getGeneralEntityOriginal());
					
					estadoregistroformapagobancoLocal.setId(estadoregistroformapagobanco.getId());	
					estadoregistroformapagobancoLocal.setVersionRow(estadoregistroformapagobanco.getVersionRow());	
					estadoregistroformapagobancoLocal.setcodigo(estadoregistroformapagobanco.getcodigo());	
					estadoregistroformapagobancoLocal.setnombre(estadoregistroformapagobanco.getnombre());	
					
					
					estadoregistroformapagobancoLocal.setRegistroFormaPagoBancos(estadoregistroformapagobanco.getRegistroFormaPagoBancos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoregistroformapagobanco.getIsDeleted()) {
				if(!existe) {
					estadoregistroformapagobancos.add(estadoregistroformapagobanco);
				}
			} else {
				if(estadoregistroformapagobancoEncontrado!=null && permiteQuitar)  {
					estadoregistroformapagobancos.remove(estadoregistroformapagobancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos) throws Exception {
		try	{			
			for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoLocal:estadoregistroformapagobancos) {
				if(estadoregistroformapagobancoLocal.getId().equals(estadoregistroformapagobanco.getId())) {
					estadoregistroformapagobancoLocal.setIsSelected(estadoregistroformapagobanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoRegistroFormaPagoBanco(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosAux) throws Exception {
		//this.estadoregistroformapagobancosAux=estadoregistroformapagobancosAux;
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux:estadoregistroformapagobancosAux) {
			if(estadoregistroformapagobancoAux.getIsChanged()) {
				estadoregistroformapagobancoAux.setIsChanged(false);
			}		
			
			if(estadoregistroformapagobancoAux.getIsNew()) {
				estadoregistroformapagobancoAux.setIsNew(false);
			}	
			
			if(estadoregistroformapagobancoAux.getIsDeleted()) {
				estadoregistroformapagobancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAux) throws Exception {
		//this.estadoregistroformapagobancoAux=estadoregistroformapagobancoAux;
		
			if(estadoregistroformapagobancoAux.getIsChanged()) {
				estadoregistroformapagobancoAux.setIsChanged(false);
			}		
			
			if(estadoregistroformapagobancoAux.getIsNew()) {
				estadoregistroformapagobancoAux.setIsNew(false);
			}	
			
			if(estadoregistroformapagobancoAux.getIsDeleted()) {
				estadoregistroformapagobancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoRegistroFormaPagoBanco estadoregistroformapagobancoAsignar,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) throws Exception {
		estadoregistroformapagobancoAsignar.setId(estadoregistroformapagobanco.getId());	
		estadoregistroformapagobancoAsignar.setVersionRow(estadoregistroformapagobanco.getVersionRow());	
		estadoregistroformapagobancoAsignar.setcodigo(estadoregistroformapagobanco.getcodigo());	
		estadoregistroformapagobancoAsignar.setnombre(estadoregistroformapagobanco.getnombre());	
	}
	
	public static void inicializarEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) throws Exception {
		try {
				estadoregistroformapagobanco.setId(0L);	
					
				estadoregistroformapagobanco.setcodigo("");	
				estadoregistroformapagobanco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoRegistroFormaPagoBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoRegistroFormaPagoBanco(String sTipo,Row row,Workbook workbook,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoregistroformapagobanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoregistroformapagobanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoRegistroFormaPagoBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoRegistroFormaPagoBanco() {
		return this.sFinalQueryEstadoRegistroFormaPagoBanco;
	}
	
	public void setsFinalQueryEstadoRegistroFormaPagoBanco(String sFinalQueryEstadoRegistroFormaPagoBanco) {
		this.sFinalQueryEstadoRegistroFormaPagoBanco= sFinalQueryEstadoRegistroFormaPagoBanco;
	}
	
	public Border resaltarSeleccionarEstadoRegistroFormaPagoBanco=null;
	
	public Border setResaltarSeleccionarEstadoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoregistroformapagobancoBeanSwingJInternalFrame.jTtoolBarEstadoRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoRegistroFormaPagoBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoRegistroFormaPagoBanco() {
		return this.resaltarSeleccionarEstadoRegistroFormaPagoBanco;
	}
	
	public void setResaltarSeleccionarEstadoRegistroFormaPagoBanco(Border borderResaltarSeleccionarEstadoRegistroFormaPagoBanco) {
		this.resaltarSeleccionarEstadoRegistroFormaPagoBanco= borderResaltarSeleccionarEstadoRegistroFormaPagoBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoRegistroFormaPagoBanco=null;
	public Boolean mostraridEstadoRegistroFormaPagoBanco=true;
	public Boolean activaridEstadoRegistroFormaPagoBanco=true;

	public Border resaltarcodigoEstadoRegistroFormaPagoBanco=null;
	public Boolean mostrarcodigoEstadoRegistroFormaPagoBanco=true;
	public Boolean activarcodigoEstadoRegistroFormaPagoBanco=true;

	public Border resaltarnombreEstadoRegistroFormaPagoBanco=null;
	public Boolean mostrarnombreEstadoRegistroFormaPagoBanco=true;
	public Boolean activarnombreEstadoRegistroFormaPagoBanco=true;

	
	

	public Border setResaltaridEstadoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoregistroformapagobancoBeanSwingJInternalFrame.jTtoolBarEstadoRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltaridEstadoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoRegistroFormaPagoBanco() {
		return this.resaltaridEstadoRegistroFormaPagoBanco;
	}

	public void setResaltaridEstadoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltaridEstadoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostraridEstadoRegistroFormaPagoBanco() {
		return this.mostraridEstadoRegistroFormaPagoBanco;
	}

	public void setMostraridEstadoRegistroFormaPagoBanco(Boolean mostraridEstadoRegistroFormaPagoBanco) {
		this.mostraridEstadoRegistroFormaPagoBanco= mostraridEstadoRegistroFormaPagoBanco;
	}

	public Boolean getActivaridEstadoRegistroFormaPagoBanco() {
		return this.activaridEstadoRegistroFormaPagoBanco;
	}

	public void setActivaridEstadoRegistroFormaPagoBanco(Boolean activaridEstadoRegistroFormaPagoBanco) {
		this.activaridEstadoRegistroFormaPagoBanco= activaridEstadoRegistroFormaPagoBanco;
	}

	public Border setResaltarcodigoEstadoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoregistroformapagobancoBeanSwingJInternalFrame.jTtoolBarEstadoRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoRegistroFormaPagoBanco() {
		return this.resaltarcodigoEstadoRegistroFormaPagoBanco;
	}

	public void setResaltarcodigoEstadoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarcodigoEstadoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoRegistroFormaPagoBanco() {
		return this.mostrarcodigoEstadoRegistroFormaPagoBanco;
	}

	public void setMostrarcodigoEstadoRegistroFormaPagoBanco(Boolean mostrarcodigoEstadoRegistroFormaPagoBanco) {
		this.mostrarcodigoEstadoRegistroFormaPagoBanco= mostrarcodigoEstadoRegistroFormaPagoBanco;
	}

	public Boolean getActivarcodigoEstadoRegistroFormaPagoBanco() {
		return this.activarcodigoEstadoRegistroFormaPagoBanco;
	}

	public void setActivarcodigoEstadoRegistroFormaPagoBanco(Boolean activarcodigoEstadoRegistroFormaPagoBanco) {
		this.activarcodigoEstadoRegistroFormaPagoBanco= activarcodigoEstadoRegistroFormaPagoBanco;
	}

	public Border setResaltarnombreEstadoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoregistroformapagobancoBeanSwingJInternalFrame.jTtoolBarEstadoRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoRegistroFormaPagoBanco() {
		return this.resaltarnombreEstadoRegistroFormaPagoBanco;
	}

	public void setResaltarnombreEstadoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnombreEstadoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoRegistroFormaPagoBanco() {
		return this.mostrarnombreEstadoRegistroFormaPagoBanco;
	}

	public void setMostrarnombreEstadoRegistroFormaPagoBanco(Boolean mostrarnombreEstadoRegistroFormaPagoBanco) {
		this.mostrarnombreEstadoRegistroFormaPagoBanco= mostrarnombreEstadoRegistroFormaPagoBanco;
	}

	public Boolean getActivarnombreEstadoRegistroFormaPagoBanco() {
		return this.activarnombreEstadoRegistroFormaPagoBanco;
	}

	public void setActivarnombreEstadoRegistroFormaPagoBanco(Boolean activarnombreEstadoRegistroFormaPagoBanco) {
		this.activarnombreEstadoRegistroFormaPagoBanco= activarnombreEstadoRegistroFormaPagoBanco;
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
		
		
		this.setMostraridEstadoRegistroFormaPagoBanco(esInicial);
		this.setMostrarcodigoEstadoRegistroFormaPagoBanco(esInicial);
		this.setMostrarnombreEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setMostraridEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoRegistroFormaPagoBanco(esAsigna);
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
		
		
		this.setActivaridEstadoRegistroFormaPagoBanco(esInicial);
		this.setActivarcodigoEstadoRegistroFormaPagoBanco(esInicial);
		this.setActivarnombreEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setActivaridEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoRegistroFormaPagoBanco(esInicial);
		this.setResaltarcodigoEstadoRegistroFormaPagoBanco(esInicial);
		this.setResaltarnombreEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setResaltaridEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco=null;

	public Border getResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco() {
		return this.resaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco;
	}

	public void setResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(Border borderResaltarRegistroFormaPagoBanco) {
		if(borderResaltarRegistroFormaPagoBanco!=null) {
			this.resaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco= borderResaltarRegistroFormaPagoBanco;
		}
	}

	public Border setResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltarRegistroFormaPagoBanco=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoregistroformapagobancoBeanSwingJInternalFrame.jTtoolBarEstadoRegistroFormaPagoBanco.setBorder(borderResaltarRegistroFormaPagoBanco);
			
		this.resaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco= borderResaltarRegistroFormaPagoBanco;

		 return borderResaltarRegistroFormaPagoBanco;
	}



	public Boolean mostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco=true;

	public Boolean getMostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco() {
		return this.mostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco;
	}

	public void setMostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(Boolean visibilidadResaltarRegistroFormaPagoBanco) {
		this.mostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco= visibilidadResaltarRegistroFormaPagoBanco;
	}



	public Boolean activarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco=true;

	public Boolean gethabilitarResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco() {
		return this.activarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco;
	}

	public void setActivarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(Boolean habilitarResaltarRegistroFormaPagoBanco) {
		this.activarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco= habilitarResaltarRegistroFormaPagoBanco;
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

		this.setMostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setMostrarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esAsigna);
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

		this.setActivarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setActivarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRegistroFormaPagoBancoBeanSwingJInternalFrame estadoregistroformapagobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setResaltarRegistroFormaPagoBancoEstadoRegistroFormaPagoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}