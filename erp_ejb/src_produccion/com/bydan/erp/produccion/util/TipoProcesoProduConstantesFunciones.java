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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoProcesoProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoProcesoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoProcesoProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoProcesoProduConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProcesoProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProcesoProdu"+TipoProcesoProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProcesoProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProcesoProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProcesoProduConstantesFunciones.SCHEMA+"_"+TipoProcesoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProcesoProduConstantesFunciones.SCHEMA+"_"+TipoProcesoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProcesoProduConstantesFunciones.SCHEMA+"_"+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProcesoProduConstantesFunciones.SCHEMA+"_"+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProcesoProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProcesoProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProcesoProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProcesoProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Proceso Produccions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Proceso Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Proceso Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProcesoProdu";
	public static final String OBJECTNAME="tipoprocesoprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_proceso_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprocesoprodu from "+TipoProcesoProduConstantesFunciones.SPERSISTENCENAME+" tipoprocesoprodu";
	public static String QUERYSELECTNATIVE="select "+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME+".id,"+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME+".version_row,"+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME+".nombre,"+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME+".descripcion from "+TipoProcesoProduConstantesFunciones.SCHEMA+"."+TipoProcesoProduConstantesFunciones.TABLENAME;//+" as "+TipoProcesoProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoProcesoProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProcesoProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoProcesoProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoProcesoProduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProcesoProduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoProcesoProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoProcesoProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoProcesoProduDescripcion(TipoProcesoProdu tipoprocesoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprocesoprodu !=null/* && tipoprocesoprodu.getId()!=0*/) {
			if(tipoprocesoprodu.getId()!=null) {
				sDescripcion=tipoprocesoprodu.getId().toString();
			}//tipoprocesoprodutipoprocesoprodu.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProcesoProduDescripcionDetallado(TipoProcesoProdu tipoprocesoprodu) {
		String sDescripcion="";
			
		sDescripcion+=TipoProcesoProduConstantesFunciones.ID+"=";
		sDescripcion+=tipoprocesoprodu.getId().toString()+",";
		sDescripcion+=TipoProcesoProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprocesoprodu.getVersionRow().toString()+",";
		sDescripcion+=TipoProcesoProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoprocesoprodu.getid_empresa().toString()+",";
		sDescripcion+=TipoProcesoProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprocesoprodu.getnombre()+",";
		sDescripcion+=TipoProcesoProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoprocesoprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProcesoProduDescripcion(TipoProcesoProdu tipoprocesoprodu,String sValor) throws Exception {			
		if(tipoprocesoprodu !=null) {
			;//tipoprocesoprodutipoprocesoprodu.getId().toString().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprocesoprodu.setnombre(tipoprocesoprodu.getnombre().trim());
		tipoprocesoprodu.setdescripcion(tipoprocesoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoProcesoProdus(List<TipoProcesoProdu> tipoprocesoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProcesoProdu tipoprocesoprodu: tipoprocesoprodus) {
			tipoprocesoprodu.setnombre(tipoprocesoprodu.getnombre().trim());
			tipoprocesoprodu.setdescripcion(tipoprocesoprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprocesoprodu.getConCambioAuxiliar()) {
			tipoprocesoprodu.setIsDeleted(tipoprocesoprodu.getIsDeletedAuxiliar());	
			tipoprocesoprodu.setIsNew(tipoprocesoprodu.getIsNewAuxiliar());	
			tipoprocesoprodu.setIsChanged(tipoprocesoprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprocesoprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprocesoprodu.setIsDeletedAuxiliar(false);	
			tipoprocesoprodu.setIsNewAuxiliar(false);	
			tipoprocesoprodu.setIsChangedAuxiliar(false);
			
			tipoprocesoprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoProdus(List<TipoProcesoProdu> tipoprocesoprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProcesoProdu tipoprocesoprodu : tipoprocesoprodus) {
			if(conAsignarBase && tipoprocesoprodu.getConCambioAuxiliar()) {
				tipoprocesoprodu.setIsDeleted(tipoprocesoprodu.getIsDeletedAuxiliar());	
				tipoprocesoprodu.setIsNew(tipoprocesoprodu.getIsNewAuxiliar());	
				tipoprocesoprodu.setIsChanged(tipoprocesoprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprocesoprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprocesoprodu.setIsDeletedAuxiliar(false);	
				tipoprocesoprodu.setIsNewAuxiliar(false);	
				tipoprocesoprodu.setIsChangedAuxiliar(false);
				
				tipoprocesoprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProcesoProdus(List<TipoProcesoProdu> tipoprocesoprodus,Boolean conEnteros) throws Exception  {
		
		for(TipoProcesoProdu tipoprocesoprodu: tipoprocesoprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProcesoProdu(List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProdu tipoprocesoproduAux) throws Exception  {
		TipoProcesoProduConstantesFunciones.InicializarValoresTipoProcesoProdu(tipoprocesoproduAux,true);
		
		for(TipoProcesoProdu tipoprocesoprodu: tipoprocesoprodus) {
			if(tipoprocesoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProcesoProduConstantesFunciones.getArrayColumnasGlobalesTipoProcesoProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoProcesoProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoProcesoProduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProcesoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProdu tipoprocesoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProcesoProdu tipoprocesoproduAux: tipoprocesoprodus) {
			if(tipoprocesoproduAux!=null && tipoprocesoprodu!=null) {
				if((tipoprocesoproduAux.getId()==null && tipoprocesoprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprocesoproduAux.getId()!=null && tipoprocesoprodu.getId()!=null){
					if(tipoprocesoproduAux.getId().equals(tipoprocesoprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProcesoProdu(List<TipoProcesoProdu> tipoprocesoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProcesoProdu tipoprocesoprodu: tipoprocesoprodus) {			
			if(tipoprocesoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProcesoProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProcesoProduConstantesFunciones.LABEL_ID, TipoProcesoProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoProduConstantesFunciones.LABEL_VERSIONROW, TipoProcesoProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoProduConstantesFunciones.LABEL_IDEMPRESA, TipoProcesoProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoProduConstantesFunciones.LABEL_NOMBRE, TipoProcesoProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoProduConstantesFunciones.LABEL_DESCRIPCION, TipoProcesoProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProcesoProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoProdu() throws Exception  {
		return TipoProcesoProduConstantesFunciones.getTiposSeleccionarTipoProcesoProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoProdu(Boolean conFk) throws Exception  {
		return TipoProcesoProduConstantesFunciones.getTiposSeleccionarTipoProcesoProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoProcesoProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProcesoProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoProcesoProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProcesoProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoProdu(TipoProcesoProdu tipoprocesoproduAux) throws Exception {
		
			tipoprocesoproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprocesoproduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoProdu(List<TipoProcesoProdu> tipoprocesoprodusTemp) throws Exception {
		for(TipoProcesoProdu tipoprocesoproduAux:tipoprocesoprodusTemp) {
			
			tipoprocesoproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprocesoproduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProcesoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoProduConstantesFunciones.getClassesRelationshipsOfTipoProcesoProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				classes.add(new Classe(PedidoDetaProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoDetaProdu.class)) {
						classes.add(new Classe(PedidoDetaProdu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoProduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProcesoProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}

					if(PedidoDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoDetaProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}

					if(PedidoDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoDetaProdu.class)); continue;
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
	public static void actualizarLista(TipoProcesoProdu tipoprocesoprodu,List<TipoProcesoProdu> tipoprocesoprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProcesoProdu tipoprocesoproduEncontrado=null;
			
			for(TipoProcesoProdu tipoprocesoproduLocal:tipoprocesoprodus) {
				if(tipoprocesoproduLocal.getId().equals(tipoprocesoprodu.getId())) {
					tipoprocesoproduEncontrado=tipoprocesoproduLocal;
					
					tipoprocesoproduLocal.setIsChanged(tipoprocesoprodu.getIsChanged());
					tipoprocesoproduLocal.setIsNew(tipoprocesoprodu.getIsNew());
					tipoprocesoproduLocal.setIsDeleted(tipoprocesoprodu.getIsDeleted());
					
					tipoprocesoproduLocal.setGeneralEntityOriginal(tipoprocesoprodu.getGeneralEntityOriginal());
					
					tipoprocesoproduLocal.setId(tipoprocesoprodu.getId());	
					tipoprocesoproduLocal.setVersionRow(tipoprocesoprodu.getVersionRow());	
					tipoprocesoproduLocal.setid_empresa(tipoprocesoprodu.getid_empresa());	
					tipoprocesoproduLocal.setnombre(tipoprocesoprodu.getnombre());	
					tipoprocesoproduLocal.setdescripcion(tipoprocesoprodu.getdescripcion());	
					
					
					tipoprocesoproduLocal.setPedidoDetaProdus(tipoprocesoprodu.getPedidoDetaProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprocesoprodu.getIsDeleted()) {
				if(!existe) {
					tipoprocesoprodus.add(tipoprocesoprodu);
				}
			} else {
				if(tipoprocesoproduEncontrado!=null && permiteQuitar)  {
					tipoprocesoprodus.remove(tipoprocesoproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProcesoProdu tipoprocesoprodu,List<TipoProcesoProdu> tipoprocesoprodus) throws Exception {
		try	{			
			for(TipoProcesoProdu tipoprocesoproduLocal:tipoprocesoprodus) {
				if(tipoprocesoproduLocal.getId().equals(tipoprocesoprodu.getId())) {
					tipoprocesoproduLocal.setIsSelected(tipoprocesoprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProcesoProdu(List<TipoProcesoProdu> tipoprocesoprodusAux) throws Exception {
		//this.tipoprocesoprodusAux=tipoprocesoprodusAux;
		
		for(TipoProcesoProdu tipoprocesoproduAux:tipoprocesoprodusAux) {
			if(tipoprocesoproduAux.getIsChanged()) {
				tipoprocesoproduAux.setIsChanged(false);
			}		
			
			if(tipoprocesoproduAux.getIsNew()) {
				tipoprocesoproduAux.setIsNew(false);
			}	
			
			if(tipoprocesoproduAux.getIsDeleted()) {
				tipoprocesoproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProcesoProdu(TipoProcesoProdu tipoprocesoproduAux) throws Exception {
		//this.tipoprocesoproduAux=tipoprocesoproduAux;
		
			if(tipoprocesoproduAux.getIsChanged()) {
				tipoprocesoproduAux.setIsChanged(false);
			}		
			
			if(tipoprocesoproduAux.getIsNew()) {
				tipoprocesoproduAux.setIsNew(false);
			}	
			
			if(tipoprocesoproduAux.getIsDeleted()) {
				tipoprocesoproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProcesoProdu tipoprocesoproduAsignar,TipoProcesoProdu tipoprocesoprodu) throws Exception {
		tipoprocesoproduAsignar.setId(tipoprocesoprodu.getId());	
		tipoprocesoproduAsignar.setVersionRow(tipoprocesoprodu.getVersionRow());	
		tipoprocesoproduAsignar.setid_empresa(tipoprocesoprodu.getid_empresa());
		tipoprocesoproduAsignar.setempresa_descripcion(tipoprocesoprodu.getempresa_descripcion());	
		tipoprocesoproduAsignar.setnombre(tipoprocesoprodu.getnombre());	
		tipoprocesoproduAsignar.setdescripcion(tipoprocesoprodu.getdescripcion());	
	}
	
	public static void inicializarTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu) throws Exception {
		try {
				tipoprocesoprodu.setId(0L);	
					
				tipoprocesoprodu.setid_empresa(-1L);	
				tipoprocesoprodu.setnombre("");	
				tipoprocesoprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProcesoProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProcesoProdu(String sTipo,Row row,Workbook workbook,TipoProcesoProdu tipoprocesoprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProcesoProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProcesoProdu() {
		return this.sFinalQueryTipoProcesoProdu;
	}
	
	public void setsFinalQueryTipoProcesoProdu(String sFinalQueryTipoProcesoProdu) {
		this.sFinalQueryTipoProcesoProdu= sFinalQueryTipoProcesoProdu;
	}
	
	public Border resaltarSeleccionarTipoProcesoProdu=null;
	
	public Border setResaltarSeleccionarTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProcesoProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProcesoProdu() {
		return this.resaltarSeleccionarTipoProcesoProdu;
	}
	
	public void setResaltarSeleccionarTipoProcesoProdu(Border borderResaltarSeleccionarTipoProcesoProdu) {
		this.resaltarSeleccionarTipoProcesoProdu= borderResaltarSeleccionarTipoProcesoProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProcesoProdu=null;
	public Boolean mostraridTipoProcesoProdu=true;
	public Boolean activaridTipoProcesoProdu=true;

	public Border resaltarid_empresaTipoProcesoProdu=null;
	public Boolean mostrarid_empresaTipoProcesoProdu=true;
	public Boolean activarid_empresaTipoProcesoProdu=true;
	public Boolean cargarid_empresaTipoProcesoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoProcesoProdu=false;//ConEventDepend=true

	public Border resaltarnombreTipoProcesoProdu=null;
	public Boolean mostrarnombreTipoProcesoProdu=true;
	public Boolean activarnombreTipoProcesoProdu=true;

	public Border resaltardescripcionTipoProcesoProdu=null;
	public Boolean mostrardescripcionTipoProcesoProdu=true;
	public Boolean activardescripcionTipoProcesoProdu=true;

	
	

	public Border setResaltaridTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltar);
		
		this.resaltaridTipoProcesoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProcesoProdu() {
		return this.resaltaridTipoProcesoProdu;
	}

	public void setResaltaridTipoProcesoProdu(Border borderResaltar) {
		this.resaltaridTipoProcesoProdu= borderResaltar;
	}

	public Boolean getMostraridTipoProcesoProdu() {
		return this.mostraridTipoProcesoProdu;
	}

	public void setMostraridTipoProcesoProdu(Boolean mostraridTipoProcesoProdu) {
		this.mostraridTipoProcesoProdu= mostraridTipoProcesoProdu;
	}

	public Boolean getActivaridTipoProcesoProdu() {
		return this.activaridTipoProcesoProdu;
	}

	public void setActivaridTipoProcesoProdu(Boolean activaridTipoProcesoProdu) {
		this.activaridTipoProcesoProdu= activaridTipoProcesoProdu;
	}

	public Border setResaltarid_empresaTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoProcesoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoProcesoProdu() {
		return this.resaltarid_empresaTipoProcesoProdu;
	}

	public void setResaltarid_empresaTipoProcesoProdu(Border borderResaltar) {
		this.resaltarid_empresaTipoProcesoProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoProcesoProdu() {
		return this.mostrarid_empresaTipoProcesoProdu;
	}

	public void setMostrarid_empresaTipoProcesoProdu(Boolean mostrarid_empresaTipoProcesoProdu) {
		this.mostrarid_empresaTipoProcesoProdu= mostrarid_empresaTipoProcesoProdu;
	}

	public Boolean getActivarid_empresaTipoProcesoProdu() {
		return this.activarid_empresaTipoProcesoProdu;
	}

	public void setActivarid_empresaTipoProcesoProdu(Boolean activarid_empresaTipoProcesoProdu) {
		this.activarid_empresaTipoProcesoProdu= activarid_empresaTipoProcesoProdu;
	}

	public Boolean getCargarid_empresaTipoProcesoProdu() {
		return this.cargarid_empresaTipoProcesoProdu;
	}

	public void setCargarid_empresaTipoProcesoProdu(Boolean cargarid_empresaTipoProcesoProdu) {
		this.cargarid_empresaTipoProcesoProdu= cargarid_empresaTipoProcesoProdu;
	}

	public Border setResaltarnombreTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProcesoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProcesoProdu() {
		return this.resaltarnombreTipoProcesoProdu;
	}

	public void setResaltarnombreTipoProcesoProdu(Border borderResaltar) {
		this.resaltarnombreTipoProcesoProdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProcesoProdu() {
		return this.mostrarnombreTipoProcesoProdu;
	}

	public void setMostrarnombreTipoProcesoProdu(Boolean mostrarnombreTipoProcesoProdu) {
		this.mostrarnombreTipoProcesoProdu= mostrarnombreTipoProcesoProdu;
	}

	public Boolean getActivarnombreTipoProcesoProdu() {
		return this.activarnombreTipoProcesoProdu;
	}

	public void setActivarnombreTipoProcesoProdu(Boolean activarnombreTipoProcesoProdu) {
		this.activarnombreTipoProcesoProdu= activarnombreTipoProcesoProdu;
	}

	public Border setResaltardescripcionTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoProcesoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoProcesoProdu() {
		return this.resaltardescripcionTipoProcesoProdu;
	}

	public void setResaltardescripcionTipoProcesoProdu(Border borderResaltar) {
		this.resaltardescripcionTipoProcesoProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoProcesoProdu() {
		return this.mostrardescripcionTipoProcesoProdu;
	}

	public void setMostrardescripcionTipoProcesoProdu(Boolean mostrardescripcionTipoProcesoProdu) {
		this.mostrardescripcionTipoProcesoProdu= mostrardescripcionTipoProcesoProdu;
	}

	public Boolean getActivardescripcionTipoProcesoProdu() {
		return this.activardescripcionTipoProcesoProdu;
	}

	public void setActivardescripcionTipoProcesoProdu(Boolean activardescripcionTipoProcesoProdu) {
		this.activardescripcionTipoProcesoProdu= activardescripcionTipoProcesoProdu;
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
		
		
		this.setMostraridTipoProcesoProdu(esInicial);
		this.setMostrarid_empresaTipoProcesoProdu(esInicial);
		this.setMostrarnombreTipoProcesoProdu(esInicial);
		this.setMostrardescripcionTipoProcesoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.ID)) {
				this.setMostraridTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoProcesoProdu(esAsigna);
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
		
		
		this.setActivaridTipoProcesoProdu(esInicial);
		this.setActivarid_empresaTipoProcesoProdu(esInicial);
		this.setActivarnombreTipoProcesoProdu(esInicial);
		this.setActivardescripcionTipoProcesoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.ID)) {
				this.setActivaridTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoProcesoProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProcesoProdu(esInicial);
		this.setResaltarid_empresaTipoProcesoProdu(esInicial);
		this.setResaltarnombreTipoProcesoProdu(esInicial);
		this.setResaltardescripcionTipoProcesoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.ID)) {
				this.setResaltaridTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProcesoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoProcesoProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoDetaProduTipoProcesoProdu=null;

	public Border getResaltarPedidoDetaProduTipoProcesoProdu() {
		return this.resaltarPedidoDetaProduTipoProcesoProdu;
	}

	public void setResaltarPedidoDetaProduTipoProcesoProdu(Border borderResaltarPedidoDetaProdu) {
		if(borderResaltarPedidoDetaProdu!=null) {
			this.resaltarPedidoDetaProduTipoProcesoProdu= borderResaltarPedidoDetaProdu;
		}
	}

	public Border setResaltarPedidoDetaProduTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoDetaProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprocesoproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoProdu.setBorder(borderResaltarPedidoDetaProdu);
			
		this.resaltarPedidoDetaProduTipoProcesoProdu= borderResaltarPedidoDetaProdu;

		 return borderResaltarPedidoDetaProdu;
	}



	public Boolean mostrarPedidoDetaProduTipoProcesoProdu=true;

	public Boolean getMostrarPedidoDetaProduTipoProcesoProdu() {
		return this.mostrarPedidoDetaProduTipoProcesoProdu;
	}

	public void setMostrarPedidoDetaProduTipoProcesoProdu(Boolean visibilidadResaltarPedidoDetaProdu) {
		this.mostrarPedidoDetaProduTipoProcesoProdu= visibilidadResaltarPedidoDetaProdu;
	}



	public Boolean activarPedidoDetaProduTipoProcesoProdu=true;

	public Boolean gethabilitarResaltarPedidoDetaProduTipoProcesoProdu() {
		return this.activarPedidoDetaProduTipoProcesoProdu;
	}

	public void setActivarPedidoDetaProduTipoProcesoProdu(Boolean habilitarResaltarPedidoDetaProdu) {
		this.activarPedidoDetaProduTipoProcesoProdu= habilitarResaltarPedidoDetaProdu;
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

		this.setMostrarPedidoDetaProduTipoProcesoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setMostrarPedidoDetaProduTipoProcesoProdu(esAsigna);
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

		this.setActivarPedidoDetaProduTipoProcesoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setActivarPedidoDetaProduTipoProcesoProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoDetaProduTipoProcesoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setResaltarPedidoDetaProduTipoProcesoProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoProcesoProdu=true;

	public Boolean getMostrarFK_IdEmpresaTipoProcesoProdu() {
		return this.mostrarFK_IdEmpresaTipoProcesoProdu;
	}

	public void setMostrarFK_IdEmpresaTipoProcesoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoProcesoProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoProcesoProdu=true;

	public Boolean getActivarFK_IdEmpresaTipoProcesoProdu() {
		return this.activarFK_IdEmpresaTipoProcesoProdu;
	}

	public void setActivarFK_IdEmpresaTipoProcesoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoProcesoProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoProcesoProdu=null;

	public Border getResaltarFK_IdEmpresaTipoProcesoProdu() {
		return this.resaltarFK_IdEmpresaTipoProcesoProdu;
	}

	public void setResaltarFK_IdEmpresaTipoProcesoProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoProcesoProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoProcesoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoProduBeanSwingJInternalFrame tipoprocesoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoProcesoProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}