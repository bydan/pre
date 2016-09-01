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


import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoConceptoFlujoCajaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoConceptoFlujoCaja";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoConceptoFlujoCaja"+TipoConceptoFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoConceptoFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoConceptoFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoConceptoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoConceptoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConceptoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConceptoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConceptoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoConceptoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoConceptoFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoConceptoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoConceptoFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Concepto Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Concepto Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Concepto Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoConceptoFlujoCaja";
	public static final String OBJECTNAME="tipoconceptoflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_concepto_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoconceptoflujocaja from "+TipoConceptoFlujoCajaConstantesFunciones.SPERSISTENCENAME+" tipoconceptoflujocaja";
	public static String QUERYSELECTNATIVE="select "+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME+".id,"+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME+".codigo,"+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME+".nombre from "+TipoConceptoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME;//+" as "+TipoConceptoFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoConceptoFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoConceptoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoConceptoFlujoCajaConstantesFunciones.CODIGO)) {sLabelColumna=TipoConceptoFlujoCajaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoConceptoFlujoCajaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoConceptoFlujoCajaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoConceptoFlujoCajaDescripcion(TipoConceptoFlujoCaja tipoconceptoflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoconceptoflujocaja !=null/* && tipoconceptoflujocaja.getId()!=0*/) {
			sDescripcion=tipoconceptoflujocaja.getcodigo();//tipoconceptoflujocajatipoconceptoflujocaja.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoConceptoFlujoCajaDescripcionDetallado(TipoConceptoFlujoCaja tipoconceptoflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=TipoConceptoFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=tipoconceptoflujocaja.getId().toString()+",";
		sDescripcion+=TipoConceptoFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoconceptoflujocaja.getVersionRow().toString()+",";
		sDescripcion+=TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoconceptoflujocaja.getid_empresa().toString()+",";
		sDescripcion+=TipoConceptoFlujoCajaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoconceptoflujocaja.getcodigo()+",";
		sDescripcion+=TipoConceptoFlujoCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoconceptoflujocaja.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoConceptoFlujoCajaDescripcion(TipoConceptoFlujoCaja tipoconceptoflujocaja,String sValor) throws Exception {			
		if(tipoconceptoflujocaja !=null) {
			tipoconceptoflujocaja.setcodigo(sValor);;//tipoconceptoflujocajatipoconceptoflujocaja.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
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

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoconceptoflujocaja.setcodigo(tipoconceptoflujocaja.getcodigo().trim());
		tipoconceptoflujocaja.setnombre(tipoconceptoflujocaja.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoConceptoFlujoCajas(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja: tipoconceptoflujocajas) {
			tipoconceptoflujocaja.setcodigo(tipoconceptoflujocaja.getcodigo().trim());
			tipoconceptoflujocaja.setnombre(tipoconceptoflujocaja.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoconceptoflujocaja.getConCambioAuxiliar()) {
			tipoconceptoflujocaja.setIsDeleted(tipoconceptoflujocaja.getIsDeletedAuxiliar());	
			tipoconceptoflujocaja.setIsNew(tipoconceptoflujocaja.getIsNewAuxiliar());	
			tipoconceptoflujocaja.setIsChanged(tipoconceptoflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoconceptoflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoconceptoflujocaja.setIsDeletedAuxiliar(false);	
			tipoconceptoflujocaja.setIsNewAuxiliar(false);	
			tipoconceptoflujocaja.setIsChangedAuxiliar(false);
			
			tipoconceptoflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConceptoFlujoCajas(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja : tipoconceptoflujocajas) {
			if(conAsignarBase && tipoconceptoflujocaja.getConCambioAuxiliar()) {
				tipoconceptoflujocaja.setIsDeleted(tipoconceptoflujocaja.getIsDeletedAuxiliar());	
				tipoconceptoflujocaja.setIsNew(tipoconceptoflujocaja.getIsNewAuxiliar());	
				tipoconceptoflujocaja.setIsChanged(tipoconceptoflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoconceptoflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoconceptoflujocaja.setIsDeletedAuxiliar(false);	
				tipoconceptoflujocaja.setIsNewAuxiliar(false);	
				tipoconceptoflujocaja.setIsChangedAuxiliar(false);
				
				tipoconceptoflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoConceptoFlujoCajas(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,Boolean conEnteros) throws Exception  {
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja: tipoconceptoflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCaja tipoconceptoflujocajaAux) throws Exception  {
		TipoConceptoFlujoCajaConstantesFunciones.InicializarValoresTipoConceptoFlujoCaja(tipoconceptoflujocajaAux,true);
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja: tipoconceptoflujocajas) {
			if(tipoconceptoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConceptoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoConceptoFlujoCajaConstantesFunciones.getArrayColumnasGlobalesTipoConceptoFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConceptoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoConceptoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCaja tipoconceptoflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocajaAux: tipoconceptoflujocajas) {
			if(tipoconceptoflujocajaAux!=null && tipoconceptoflujocaja!=null) {
				if((tipoconceptoflujocajaAux.getId()==null && tipoconceptoflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoconceptoflujocajaAux.getId()!=null && tipoconceptoflujocaja.getId()!=null){
					if(tipoconceptoflujocajaAux.getId().equals(tipoconceptoflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> tipoconceptoflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja: tipoconceptoflujocajas) {			
			if(tipoconceptoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoConceptoFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoConceptoFlujoCajaConstantesFunciones.LABEL_ID, TipoConceptoFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConceptoFlujoCajaConstantesFunciones.LABEL_VERSIONROW, TipoConceptoFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConceptoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA, TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConceptoFlujoCajaConstantesFunciones.LABEL_CODIGO, TipoConceptoFlujoCajaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConceptoFlujoCajaConstantesFunciones.LABEL_NOMBRE, TipoConceptoFlujoCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoConceptoFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoConceptoFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConceptoFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConceptoFlujoCajaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConceptoFlujoCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConceptoFlujoCaja() throws Exception  {
		return TipoConceptoFlujoCajaConstantesFunciones.getTiposSeleccionarTipoConceptoFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConceptoFlujoCaja(Boolean conFk) throws Exception  {
		return TipoConceptoFlujoCajaConstantesFunciones.getTiposSeleccionarTipoConceptoFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConceptoFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConceptoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoConceptoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConceptoFlujoCajaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoConceptoFlujoCajaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConceptoFlujoCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoConceptoFlujoCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoConceptoFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocajaAux) throws Exception {
		
			tipoconceptoflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoconceptoflujocajaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> tipoconceptoflujocajasTemp) throws Exception {
		for(TipoConceptoFlujoCaja tipoconceptoflujocajaAux:tipoconceptoflujocajasTemp) {
			
			tipoconceptoflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoconceptoflujocajaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConceptoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoConceptoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConceptoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConceptoFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoConceptoFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConceptoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConceptoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConceptoFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoConceptoFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConceptoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoConceptoFlujoCaja tipoconceptoflujocaja,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoConceptoFlujoCaja tipoconceptoflujocajaEncontrado=null;
			
			for(TipoConceptoFlujoCaja tipoconceptoflujocajaLocal:tipoconceptoflujocajas) {
				if(tipoconceptoflujocajaLocal.getId().equals(tipoconceptoflujocaja.getId())) {
					tipoconceptoflujocajaEncontrado=tipoconceptoflujocajaLocal;
					
					tipoconceptoflujocajaLocal.setIsChanged(tipoconceptoflujocaja.getIsChanged());
					tipoconceptoflujocajaLocal.setIsNew(tipoconceptoflujocaja.getIsNew());
					tipoconceptoflujocajaLocal.setIsDeleted(tipoconceptoflujocaja.getIsDeleted());
					
					tipoconceptoflujocajaLocal.setGeneralEntityOriginal(tipoconceptoflujocaja.getGeneralEntityOriginal());
					
					tipoconceptoflujocajaLocal.setId(tipoconceptoflujocaja.getId());	
					tipoconceptoflujocajaLocal.setVersionRow(tipoconceptoflujocaja.getVersionRow());	
					tipoconceptoflujocajaLocal.setid_empresa(tipoconceptoflujocaja.getid_empresa());	
					tipoconceptoflujocajaLocal.setcodigo(tipoconceptoflujocaja.getcodigo());	
					tipoconceptoflujocajaLocal.setnombre(tipoconceptoflujocaja.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoconceptoflujocaja.getIsDeleted()) {
				if(!existe) {
					tipoconceptoflujocajas.add(tipoconceptoflujocaja);
				}
			} else {
				if(tipoconceptoflujocajaEncontrado!=null && permiteQuitar)  {
					tipoconceptoflujocajas.remove(tipoconceptoflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoConceptoFlujoCaja tipoconceptoflujocaja,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas) throws Exception {
		try	{			
			for(TipoConceptoFlujoCaja tipoconceptoflujocajaLocal:tipoconceptoflujocajas) {
				if(tipoconceptoflujocajaLocal.getId().equals(tipoconceptoflujocaja.getId())) {
					tipoconceptoflujocajaLocal.setIsSelected(tipoconceptoflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> tipoconceptoflujocajasAux) throws Exception {
		//this.tipoconceptoflujocajasAux=tipoconceptoflujocajasAux;
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocajaAux:tipoconceptoflujocajasAux) {
			if(tipoconceptoflujocajaAux.getIsChanged()) {
				tipoconceptoflujocajaAux.setIsChanged(false);
			}		
			
			if(tipoconceptoflujocajaAux.getIsNew()) {
				tipoconceptoflujocajaAux.setIsNew(false);
			}	
			
			if(tipoconceptoflujocajaAux.getIsDeleted()) {
				tipoconceptoflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocajaAux) throws Exception {
		//this.tipoconceptoflujocajaAux=tipoconceptoflujocajaAux;
		
			if(tipoconceptoflujocajaAux.getIsChanged()) {
				tipoconceptoflujocajaAux.setIsChanged(false);
			}		
			
			if(tipoconceptoflujocajaAux.getIsNew()) {
				tipoconceptoflujocajaAux.setIsNew(false);
			}	
			
			if(tipoconceptoflujocajaAux.getIsDeleted()) {
				tipoconceptoflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoConceptoFlujoCaja tipoconceptoflujocajaAsignar,TipoConceptoFlujoCaja tipoconceptoflujocaja) throws Exception {
		tipoconceptoflujocajaAsignar.setId(tipoconceptoflujocaja.getId());	
		tipoconceptoflujocajaAsignar.setVersionRow(tipoconceptoflujocaja.getVersionRow());	
		tipoconceptoflujocajaAsignar.setid_empresa(tipoconceptoflujocaja.getid_empresa());
		tipoconceptoflujocajaAsignar.setempresa_descripcion(tipoconceptoflujocaja.getempresa_descripcion());	
		tipoconceptoflujocajaAsignar.setcodigo(tipoconceptoflujocaja.getcodigo());	
		tipoconceptoflujocajaAsignar.setnombre(tipoconceptoflujocaja.getnombre());	
	}
	
	public static void inicializarTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocaja) throws Exception {
		try {
				tipoconceptoflujocaja.setId(0L);	
					
				tipoconceptoflujocaja.setid_empresa(-1L);	
				tipoconceptoflujocaja.setcodigo("");	
				tipoconceptoflujocaja.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoConceptoFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConceptoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConceptoFlujoCajaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConceptoFlujoCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoConceptoFlujoCaja(String sTipo,Row row,Workbook workbook,TipoConceptoFlujoCaja tipoconceptoflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconceptoflujocaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconceptoflujocaja.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconceptoflujocaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoConceptoFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoConceptoFlujoCaja() {
		return this.sFinalQueryTipoConceptoFlujoCaja;
	}
	
	public void setsFinalQueryTipoConceptoFlujoCaja(String sFinalQueryTipoConceptoFlujoCaja) {
		this.sFinalQueryTipoConceptoFlujoCaja= sFinalQueryTipoConceptoFlujoCaja;
	}
	
	public Border resaltarSeleccionarTipoConceptoFlujoCaja=null;
	
	public Border setResaltarSeleccionarTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoconceptoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoConceptoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoConceptoFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoConceptoFlujoCaja() {
		return this.resaltarSeleccionarTipoConceptoFlujoCaja;
	}
	
	public void setResaltarSeleccionarTipoConceptoFlujoCaja(Border borderResaltarSeleccionarTipoConceptoFlujoCaja) {
		this.resaltarSeleccionarTipoConceptoFlujoCaja= borderResaltarSeleccionarTipoConceptoFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoConceptoFlujoCaja=null;
	public Boolean mostraridTipoConceptoFlujoCaja=true;
	public Boolean activaridTipoConceptoFlujoCaja=true;

	public Border resaltarid_empresaTipoConceptoFlujoCaja=null;
	public Boolean mostrarid_empresaTipoConceptoFlujoCaja=true;
	public Boolean activarid_empresaTipoConceptoFlujoCaja=true;
	public Boolean cargarid_empresaTipoConceptoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoConceptoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarcodigoTipoConceptoFlujoCaja=null;
	public Boolean mostrarcodigoTipoConceptoFlujoCaja=true;
	public Boolean activarcodigoTipoConceptoFlujoCaja=true;

	public Border resaltarnombreTipoConceptoFlujoCaja=null;
	public Boolean mostrarnombreTipoConceptoFlujoCaja=true;
	public Boolean activarnombreTipoConceptoFlujoCaja=true;

	
	

	public Border setResaltaridTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconceptoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoConceptoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridTipoConceptoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoConceptoFlujoCaja() {
		return this.resaltaridTipoConceptoFlujoCaja;
	}

	public void setResaltaridTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltaridTipoConceptoFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridTipoConceptoFlujoCaja() {
		return this.mostraridTipoConceptoFlujoCaja;
	}

	public void setMostraridTipoConceptoFlujoCaja(Boolean mostraridTipoConceptoFlujoCaja) {
		this.mostraridTipoConceptoFlujoCaja= mostraridTipoConceptoFlujoCaja;
	}

	public Boolean getActivaridTipoConceptoFlujoCaja() {
		return this.activaridTipoConceptoFlujoCaja;
	}

	public void setActivaridTipoConceptoFlujoCaja(Boolean activaridTipoConceptoFlujoCaja) {
		this.activaridTipoConceptoFlujoCaja= activaridTipoConceptoFlujoCaja;
	}

	public Border setResaltarid_empresaTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconceptoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoConceptoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoConceptoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoConceptoFlujoCaja() {
		return this.resaltarid_empresaTipoConceptoFlujoCaja;
	}

	public void setResaltarid_empresaTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarid_empresaTipoConceptoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoConceptoFlujoCaja() {
		return this.mostrarid_empresaTipoConceptoFlujoCaja;
	}

	public void setMostrarid_empresaTipoConceptoFlujoCaja(Boolean mostrarid_empresaTipoConceptoFlujoCaja) {
		this.mostrarid_empresaTipoConceptoFlujoCaja= mostrarid_empresaTipoConceptoFlujoCaja;
	}

	public Boolean getActivarid_empresaTipoConceptoFlujoCaja() {
		return this.activarid_empresaTipoConceptoFlujoCaja;
	}

	public void setActivarid_empresaTipoConceptoFlujoCaja(Boolean activarid_empresaTipoConceptoFlujoCaja) {
		this.activarid_empresaTipoConceptoFlujoCaja= activarid_empresaTipoConceptoFlujoCaja;
	}

	public Boolean getCargarid_empresaTipoConceptoFlujoCaja() {
		return this.cargarid_empresaTipoConceptoFlujoCaja;
	}

	public void setCargarid_empresaTipoConceptoFlujoCaja(Boolean cargarid_empresaTipoConceptoFlujoCaja) {
		this.cargarid_empresaTipoConceptoFlujoCaja= cargarid_empresaTipoConceptoFlujoCaja;
	}

	public Border setResaltarcodigoTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconceptoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoConceptoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoConceptoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoConceptoFlujoCaja() {
		return this.resaltarcodigoTipoConceptoFlujoCaja;
	}

	public void setResaltarcodigoTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarcodigoTipoConceptoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoConceptoFlujoCaja() {
		return this.mostrarcodigoTipoConceptoFlujoCaja;
	}

	public void setMostrarcodigoTipoConceptoFlujoCaja(Boolean mostrarcodigoTipoConceptoFlujoCaja) {
		this.mostrarcodigoTipoConceptoFlujoCaja= mostrarcodigoTipoConceptoFlujoCaja;
	}

	public Boolean getActivarcodigoTipoConceptoFlujoCaja() {
		return this.activarcodigoTipoConceptoFlujoCaja;
	}

	public void setActivarcodigoTipoConceptoFlujoCaja(Boolean activarcodigoTipoConceptoFlujoCaja) {
		this.activarcodigoTipoConceptoFlujoCaja= activarcodigoTipoConceptoFlujoCaja;
	}

	public Border setResaltarnombreTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconceptoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoConceptoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarnombreTipoConceptoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoConceptoFlujoCaja() {
		return this.resaltarnombreTipoConceptoFlujoCaja;
	}

	public void setResaltarnombreTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarnombreTipoConceptoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarnombreTipoConceptoFlujoCaja() {
		return this.mostrarnombreTipoConceptoFlujoCaja;
	}

	public void setMostrarnombreTipoConceptoFlujoCaja(Boolean mostrarnombreTipoConceptoFlujoCaja) {
		this.mostrarnombreTipoConceptoFlujoCaja= mostrarnombreTipoConceptoFlujoCaja;
	}

	public Boolean getActivarnombreTipoConceptoFlujoCaja() {
		return this.activarnombreTipoConceptoFlujoCaja;
	}

	public void setActivarnombreTipoConceptoFlujoCaja(Boolean activarnombreTipoConceptoFlujoCaja) {
		this.activarnombreTipoConceptoFlujoCaja= activarnombreTipoConceptoFlujoCaja;
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
		
		
		this.setMostraridTipoConceptoFlujoCaja(esInicial);
		this.setMostrarid_empresaTipoConceptoFlujoCaja(esInicial);
		this.setMostrarcodigoTipoConceptoFlujoCaja(esInicial);
		this.setMostrarnombreTipoConceptoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoConceptoFlujoCaja(esAsigna);
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
		
		
		this.setActivaridTipoConceptoFlujoCaja(esInicial);
		this.setActivarid_empresaTipoConceptoFlujoCaja(esInicial);
		this.setActivarcodigoTipoConceptoFlujoCaja(esInicial);
		this.setActivarnombreTipoConceptoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoConceptoFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoConceptoFlujoCaja(esInicial);
		this.setResaltarid_empresaTipoConceptoFlujoCaja(esInicial);
		this.setResaltarcodigoTipoConceptoFlujoCaja(esInicial);
		this.setResaltarnombreTipoConceptoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoConceptoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConceptoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoConceptoFlujoCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoConceptoFlujoCaja=true;

	public Boolean getMostrarBusquedaPorCodigoTipoConceptoFlujoCaja() {
		return this.mostrarBusquedaPorCodigoTipoConceptoFlujoCaja;
	}

	public void setMostrarBusquedaPorCodigoTipoConceptoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoConceptoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTipoConceptoFlujoCaja=true;

	public Boolean getMostrarBusquedaPorIdTipoConceptoFlujoCaja() {
		return this.mostrarBusquedaPorIdTipoConceptoFlujoCaja;
	}

	public void setMostrarBusquedaPorIdTipoConceptoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoConceptoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoConceptoFlujoCaja=true;

	public Boolean getMostrarBusquedaPorNombreTipoConceptoFlujoCaja() {
		return this.mostrarBusquedaPorNombreTipoConceptoFlujoCaja;
	}

	public void setMostrarBusquedaPorNombreTipoConceptoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoConceptoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoConceptoFlujoCaja=true;

	public Boolean getMostrarFK_IdEmpresaTipoConceptoFlujoCaja() {
		return this.mostrarFK_IdEmpresaTipoConceptoFlujoCaja;
	}

	public void setMostrarFK_IdEmpresaTipoConceptoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoConceptoFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoConceptoFlujoCaja=true;

	public Boolean getActivarBusquedaPorCodigoTipoConceptoFlujoCaja() {
		return this.activarBusquedaPorCodigoTipoConceptoFlujoCaja;
	}

	public void setActivarBusquedaPorCodigoTipoConceptoFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoConceptoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTipoConceptoFlujoCaja=true;

	public Boolean getActivarBusquedaPorIdTipoConceptoFlujoCaja() {
		return this.activarBusquedaPorIdTipoConceptoFlujoCaja;
	}

	public void setActivarBusquedaPorIdTipoConceptoFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoConceptoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoConceptoFlujoCaja=true;

	public Boolean getActivarBusquedaPorNombreTipoConceptoFlujoCaja() {
		return this.activarBusquedaPorNombreTipoConceptoFlujoCaja;
	}

	public void setActivarBusquedaPorNombreTipoConceptoFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoConceptoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoConceptoFlujoCaja=true;

	public Boolean getActivarFK_IdEmpresaTipoConceptoFlujoCaja() {
		return this.activarFK_IdEmpresaTipoConceptoFlujoCaja;
	}

	public void setActivarFK_IdEmpresaTipoConceptoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoConceptoFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoConceptoFlujoCaja=null;

	public Border getResaltarBusquedaPorCodigoTipoConceptoFlujoCaja() {
		return this.resaltarBusquedaPorCodigoTipoConceptoFlujoCaja;
	}

	public void setResaltarBusquedaPorCodigoTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoConceptoFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoConceptoFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTipoConceptoFlujoCaja=null;

	public Border getResaltarBusquedaPorIdTipoConceptoFlujoCaja() {
		return this.resaltarBusquedaPorIdTipoConceptoFlujoCaja;
	}

	public void setResaltarBusquedaPorIdTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoConceptoFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoConceptoFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoConceptoFlujoCaja=null;

	public Border getResaltarBusquedaPorNombreTipoConceptoFlujoCaja() {
		return this.resaltarBusquedaPorNombreTipoConceptoFlujoCaja;
	}

	public void setResaltarBusquedaPorNombreTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoConceptoFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoConceptoFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoConceptoFlujoCaja=null;

	public Border getResaltarFK_IdEmpresaTipoConceptoFlujoCaja() {
		return this.resaltarFK_IdEmpresaTipoConceptoFlujoCaja;
	}

	public void setResaltarFK_IdEmpresaTipoConceptoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoConceptoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoConceptoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConceptoFlujoCajaBeanSwingJInternalFrame tipoconceptoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoConceptoFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}