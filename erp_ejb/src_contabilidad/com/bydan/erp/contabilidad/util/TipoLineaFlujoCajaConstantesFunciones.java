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


import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoLineaFlujoCajaConstantesFunciones extends TipoLineaFlujoCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoLineaFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoLineaFlujoCaja"+TipoLineaFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoLineaFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoLineaFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoLineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoLineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoLineaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoLineaFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoLineaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoLineaFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Linea Flujo Caja s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Linea Flujo Caja ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Linea Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoLineaFlujoCaja";
	public static final String OBJECTNAME="tipolineaflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_linea_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipolineaflujocaja from "+TipoLineaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" tipolineaflujocaja";
	public static String QUERYSELECTNATIVE="select "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".codigo_sri from "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoLineaFlujoCajaConstantesFuncionesAdditional tipolineaflujocajaConstantesFuncionesAdditional=null;
	
	public TipoLineaFlujoCajaConstantesFuncionesAdditional getTipoLineaFlujoCajaConstantesFuncionesAdditional() {
		return this.tipolineaflujocajaConstantesFuncionesAdditional;
	}
	
	public void setTipoLineaFlujoCajaConstantesFuncionesAdditional(TipoLineaFlujoCajaConstantesFuncionesAdditional tipolineaflujocajaConstantesFuncionesAdditional) {
		try {
			this.tipolineaflujocajaConstantesFuncionesAdditional=tipolineaflujocajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOSRI= "codigo_sri";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOSRI= "Codigo Sri";
		public static final String LABEL_CODIGOSRI_LOWER= "Codigo Sri";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_SRI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SRI=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoLineaFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoLineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoLineaFlujoCajaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoLineaFlujoCajaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI)) {sLabelColumna=TipoLineaFlujoCajaConstantesFunciones.LABEL_CODIGOSRI;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoLineaFlujoCajaDescripcion(TipoLineaFlujoCaja tipolineaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipolineaflujocaja !=null/* && tipolineaflujocaja.getId()!=0*/) {
			sDescripcion=tipolineaflujocaja.getnombre();//tipolineaflujocajatipolineaflujocaja.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoLineaFlujoCajaDescripcionDetallado(TipoLineaFlujoCaja tipolineaflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=TipoLineaFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=tipolineaflujocaja.getId().toString()+",";
		sDescripcion+=TipoLineaFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipolineaflujocaja.getVersionRow().toString()+",";
		sDescripcion+=TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipolineaflujocaja.getid_empresa().toString()+",";
		sDescripcion+=TipoLineaFlujoCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipolineaflujocaja.getnombre()+",";
		sDescripcion+=TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI+"=";
		sDescripcion+=tipolineaflujocaja.getcodigo_sri()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoLineaFlujoCajaDescripcion(TipoLineaFlujoCaja tipolineaflujocaja,String sValor) throws Exception {			
		if(tipolineaflujocaja !=null) {
			tipolineaflujocaja.setnombre(sValor);;//tipolineaflujocajatipolineaflujocaja.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigoSri")) {
			sNombreIndice="Tipo=  Por Codigo Sri";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigoSri(String codigo_sri) {
		String sDetalleIndice=" Parametros->";
		if(codigo_sri!=null) {sDetalleIndice+=" Codigo Sri="+codigo_sri;} 

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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipolineaflujocaja.setnombre(tipolineaflujocaja.getnombre().trim());
		tipolineaflujocaja.setcodigo_sri(tipolineaflujocaja.getcodigo_sri().trim());
	}
	
	public static void quitarEspaciosTipoLineaFlujoCajas(List<TipoLineaFlujoCaja> tipolineaflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoLineaFlujoCaja tipolineaflujocaja: tipolineaflujocajas) {
			tipolineaflujocaja.setnombre(tipolineaflujocaja.getnombre().trim());
			tipolineaflujocaja.setcodigo_sri(tipolineaflujocaja.getcodigo_sri().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipolineaflujocaja.getConCambioAuxiliar()) {
			tipolineaflujocaja.setIsDeleted(tipolineaflujocaja.getIsDeletedAuxiliar());	
			tipolineaflujocaja.setIsNew(tipolineaflujocaja.getIsNewAuxiliar());	
			tipolineaflujocaja.setIsChanged(tipolineaflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipolineaflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipolineaflujocaja.setIsDeletedAuxiliar(false);	
			tipolineaflujocaja.setIsNewAuxiliar(false);	
			tipolineaflujocaja.setIsChangedAuxiliar(false);
			
			tipolineaflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLineaFlujoCajas(List<TipoLineaFlujoCaja> tipolineaflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoLineaFlujoCaja tipolineaflujocaja : tipolineaflujocajas) {
			if(conAsignarBase && tipolineaflujocaja.getConCambioAuxiliar()) {
				tipolineaflujocaja.setIsDeleted(tipolineaflujocaja.getIsDeletedAuxiliar());	
				tipolineaflujocaja.setIsNew(tipolineaflujocaja.getIsNewAuxiliar());	
				tipolineaflujocaja.setIsChanged(tipolineaflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipolineaflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipolineaflujocaja.setIsDeletedAuxiliar(false);	
				tipolineaflujocaja.setIsNewAuxiliar(false);	
				tipolineaflujocaja.setIsChangedAuxiliar(false);
				
				tipolineaflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoLineaFlujoCajas(List<TipoLineaFlujoCaja> tipolineaflujocajas,Boolean conEnteros) throws Exception  {
		
		for(TipoLineaFlujoCaja tipolineaflujocaja: tipolineaflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCaja tipolineaflujocajaAux) throws Exception  {
		TipoLineaFlujoCajaConstantesFunciones.InicializarValoresTipoLineaFlujoCaja(tipolineaflujocajaAux,true);
		
		for(TipoLineaFlujoCaja tipolineaflujocaja: tipolineaflujocajas) {
			if(tipolineaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoLineaFlujoCajaConstantesFunciones.getArrayColumnasGlobalesTipoLineaFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCaja tipolineaflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoLineaFlujoCaja tipolineaflujocajaAux: tipolineaflujocajas) {
			if(tipolineaflujocajaAux!=null && tipolineaflujocaja!=null) {
				if((tipolineaflujocajaAux.getId()==null && tipolineaflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipolineaflujocajaAux.getId()!=null && tipolineaflujocaja.getId()!=null){
					if(tipolineaflujocajaAux.getId().equals(tipolineaflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> tipolineaflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoLineaFlujoCaja tipolineaflujocaja: tipolineaflujocajas) {			
			if(tipolineaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoLineaFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoLineaFlujoCajaConstantesFunciones.LABEL_ID, TipoLineaFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLineaFlujoCajaConstantesFunciones.LABEL_VERSIONROW, TipoLineaFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA, TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLineaFlujoCajaConstantesFunciones.LABEL_NOMBRE, TipoLineaFlujoCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLineaFlujoCajaConstantesFunciones.LABEL_CODIGOSRI, TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoLineaFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoLineaFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLineaFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLineaFlujoCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLineaFlujoCaja() throws Exception  {
		return TipoLineaFlujoCajaConstantesFunciones.getTiposSeleccionarTipoLineaFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLineaFlujoCaja(Boolean conFk) throws Exception  {
		return TipoLineaFlujoCajaConstantesFunciones.getTiposSeleccionarTipoLineaFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLineaFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoLineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoLineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLineaFlujoCajaConstantesFunciones.LABEL_CODIGOSRI);
			reporte.setsDescripcion(TipoLineaFlujoCajaConstantesFunciones.LABEL_CODIGOSRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoLineaFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocajaAux) throws Exception {
		
			tipolineaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolineaflujocajaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> tipolineaflujocajasTemp) throws Exception {
		for(TipoLineaFlujoCaja tipolineaflujocajaAux:tipolineaflujocajasTemp) {
			
			tipolineaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolineaflujocajaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLineaFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoLineaFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(LineaFlujoCaja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(LineaFlujoCaja.class)) {
						classes.add(new Classe(LineaFlujoCaja.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLineaFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoLineaFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(LineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaFlujoCaja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(LineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaFlujoCaja.class)); continue;
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
	public static void actualizarLista(TipoLineaFlujoCaja tipolineaflujocaja,List<TipoLineaFlujoCaja> tipolineaflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoLineaFlujoCaja tipolineaflujocajaEncontrado=null;
			
			for(TipoLineaFlujoCaja tipolineaflujocajaLocal:tipolineaflujocajas) {
				if(tipolineaflujocajaLocal.getId().equals(tipolineaflujocaja.getId())) {
					tipolineaflujocajaEncontrado=tipolineaflujocajaLocal;
					
					tipolineaflujocajaLocal.setIsChanged(tipolineaflujocaja.getIsChanged());
					tipolineaflujocajaLocal.setIsNew(tipolineaflujocaja.getIsNew());
					tipolineaflujocajaLocal.setIsDeleted(tipolineaflujocaja.getIsDeleted());
					
					tipolineaflujocajaLocal.setGeneralEntityOriginal(tipolineaflujocaja.getGeneralEntityOriginal());
					
					tipolineaflujocajaLocal.setId(tipolineaflujocaja.getId());	
					tipolineaflujocajaLocal.setVersionRow(tipolineaflujocaja.getVersionRow());	
					tipolineaflujocajaLocal.setid_empresa(tipolineaflujocaja.getid_empresa());	
					tipolineaflujocajaLocal.setnombre(tipolineaflujocaja.getnombre());	
					tipolineaflujocajaLocal.setcodigo_sri(tipolineaflujocaja.getcodigo_sri());	
					
					
					tipolineaflujocajaLocal.setLineaFlujoCajas(tipolineaflujocaja.getLineaFlujoCajas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipolineaflujocaja.getIsDeleted()) {
				if(!existe) {
					tipolineaflujocajas.add(tipolineaflujocaja);
				}
			} else {
				if(tipolineaflujocajaEncontrado!=null && permiteQuitar)  {
					tipolineaflujocajas.remove(tipolineaflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoLineaFlujoCaja tipolineaflujocaja,List<TipoLineaFlujoCaja> tipolineaflujocajas) throws Exception {
		try	{			
			for(TipoLineaFlujoCaja tipolineaflujocajaLocal:tipolineaflujocajas) {
				if(tipolineaflujocajaLocal.getId().equals(tipolineaflujocaja.getId())) {
					tipolineaflujocajaLocal.setIsSelected(tipolineaflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> tipolineaflujocajasAux) throws Exception {
		//this.tipolineaflujocajasAux=tipolineaflujocajasAux;
		
		for(TipoLineaFlujoCaja tipolineaflujocajaAux:tipolineaflujocajasAux) {
			if(tipolineaflujocajaAux.getIsChanged()) {
				tipolineaflujocajaAux.setIsChanged(false);
			}		
			
			if(tipolineaflujocajaAux.getIsNew()) {
				tipolineaflujocajaAux.setIsNew(false);
			}	
			
			if(tipolineaflujocajaAux.getIsDeleted()) {
				tipolineaflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocajaAux) throws Exception {
		//this.tipolineaflujocajaAux=tipolineaflujocajaAux;
		
			if(tipolineaflujocajaAux.getIsChanged()) {
				tipolineaflujocajaAux.setIsChanged(false);
			}		
			
			if(tipolineaflujocajaAux.getIsNew()) {
				tipolineaflujocajaAux.setIsNew(false);
			}	
			
			if(tipolineaflujocajaAux.getIsDeleted()) {
				tipolineaflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoLineaFlujoCaja tipolineaflujocajaAsignar,TipoLineaFlujoCaja tipolineaflujocaja) throws Exception {
		tipolineaflujocajaAsignar.setId(tipolineaflujocaja.getId());	
		tipolineaflujocajaAsignar.setVersionRow(tipolineaflujocaja.getVersionRow());	
		tipolineaflujocajaAsignar.setid_empresa(tipolineaflujocaja.getid_empresa());
		tipolineaflujocajaAsignar.setempresa_descripcion(tipolineaflujocaja.getempresa_descripcion());	
		tipolineaflujocajaAsignar.setnombre(tipolineaflujocaja.getnombre());	
		tipolineaflujocajaAsignar.setcodigo_sri(tipolineaflujocaja.getcodigo_sri());	
	}
	
	public static void inicializarTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja) throws Exception {
		try {
				tipolineaflujocaja.setId(0L);	
					
				tipolineaflujocaja.setid_empresa(-1L);	
				tipolineaflujocaja.setnombre("");	
				tipolineaflujocaja.setcodigo_sri("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoLineaFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLineaFlujoCajaConstantesFunciones.LABEL_CODIGOSRI);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoLineaFlujoCaja(String sTipo,Row row,Workbook workbook,TipoLineaFlujoCaja tipolineaflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolineaflujocaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolineaflujocaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolineaflujocaja.getcodigo_sri());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoLineaFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoLineaFlujoCaja() {
		return this.sFinalQueryTipoLineaFlujoCaja;
	}
	
	public void setsFinalQueryTipoLineaFlujoCaja(String sFinalQueryTipoLineaFlujoCaja) {
		this.sFinalQueryTipoLineaFlujoCaja= sFinalQueryTipoLineaFlujoCaja;
	}
	
	public Border resaltarSeleccionarTipoLineaFlujoCaja=null;
	
	public Border setResaltarSeleccionarTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoLineaFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoLineaFlujoCaja() {
		return this.resaltarSeleccionarTipoLineaFlujoCaja;
	}
	
	public void setResaltarSeleccionarTipoLineaFlujoCaja(Border borderResaltarSeleccionarTipoLineaFlujoCaja) {
		this.resaltarSeleccionarTipoLineaFlujoCaja= borderResaltarSeleccionarTipoLineaFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoLineaFlujoCaja=null;
	public Boolean mostraridTipoLineaFlujoCaja=true;
	public Boolean activaridTipoLineaFlujoCaja=true;

	public Border resaltarid_empresaTipoLineaFlujoCaja=null;
	public Boolean mostrarid_empresaTipoLineaFlujoCaja=true;
	public Boolean activarid_empresaTipoLineaFlujoCaja=true;
	public Boolean cargarid_empresaTipoLineaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoLineaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarnombreTipoLineaFlujoCaja=null;
	public Boolean mostrarnombreTipoLineaFlujoCaja=true;
	public Boolean activarnombreTipoLineaFlujoCaja=true;

	public Border resaltarcodigo_sriTipoLineaFlujoCaja=null;
	public Boolean mostrarcodigo_sriTipoLineaFlujoCaja=true;
	public Boolean activarcodigo_sriTipoLineaFlujoCaja=true;

	
	

	public Border setResaltaridTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridTipoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoLineaFlujoCaja() {
		return this.resaltaridTipoLineaFlujoCaja;
	}

	public void setResaltaridTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltaridTipoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridTipoLineaFlujoCaja() {
		return this.mostraridTipoLineaFlujoCaja;
	}

	public void setMostraridTipoLineaFlujoCaja(Boolean mostraridTipoLineaFlujoCaja) {
		this.mostraridTipoLineaFlujoCaja= mostraridTipoLineaFlujoCaja;
	}

	public Boolean getActivaridTipoLineaFlujoCaja() {
		return this.activaridTipoLineaFlujoCaja;
	}

	public void setActivaridTipoLineaFlujoCaja(Boolean activaridTipoLineaFlujoCaja) {
		this.activaridTipoLineaFlujoCaja= activaridTipoLineaFlujoCaja;
	}

	public Border setResaltarid_empresaTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoLineaFlujoCaja() {
		return this.resaltarid_empresaTipoLineaFlujoCaja;
	}

	public void setResaltarid_empresaTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarid_empresaTipoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoLineaFlujoCaja() {
		return this.mostrarid_empresaTipoLineaFlujoCaja;
	}

	public void setMostrarid_empresaTipoLineaFlujoCaja(Boolean mostrarid_empresaTipoLineaFlujoCaja) {
		this.mostrarid_empresaTipoLineaFlujoCaja= mostrarid_empresaTipoLineaFlujoCaja;
	}

	public Boolean getActivarid_empresaTipoLineaFlujoCaja() {
		return this.activarid_empresaTipoLineaFlujoCaja;
	}

	public void setActivarid_empresaTipoLineaFlujoCaja(Boolean activarid_empresaTipoLineaFlujoCaja) {
		this.activarid_empresaTipoLineaFlujoCaja= activarid_empresaTipoLineaFlujoCaja;
	}

	public Boolean getCargarid_empresaTipoLineaFlujoCaja() {
		return this.cargarid_empresaTipoLineaFlujoCaja;
	}

	public void setCargarid_empresaTipoLineaFlujoCaja(Boolean cargarid_empresaTipoLineaFlujoCaja) {
		this.cargarid_empresaTipoLineaFlujoCaja= cargarid_empresaTipoLineaFlujoCaja;
	}

	public Border setResaltarnombreTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarnombreTipoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoLineaFlujoCaja() {
		return this.resaltarnombreTipoLineaFlujoCaja;
	}

	public void setResaltarnombreTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarnombreTipoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarnombreTipoLineaFlujoCaja() {
		return this.mostrarnombreTipoLineaFlujoCaja;
	}

	public void setMostrarnombreTipoLineaFlujoCaja(Boolean mostrarnombreTipoLineaFlujoCaja) {
		this.mostrarnombreTipoLineaFlujoCaja= mostrarnombreTipoLineaFlujoCaja;
	}

	public Boolean getActivarnombreTipoLineaFlujoCaja() {
		return this.activarnombreTipoLineaFlujoCaja;
	}

	public void setActivarnombreTipoLineaFlujoCaja(Boolean activarnombreTipoLineaFlujoCaja) {
		this.activarnombreTipoLineaFlujoCaja= activarnombreTipoLineaFlujoCaja;
	}

	public Border setResaltarcodigo_sriTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarcodigo_sriTipoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sriTipoLineaFlujoCaja() {
		return this.resaltarcodigo_sriTipoLineaFlujoCaja;
	}

	public void setResaltarcodigo_sriTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarcodigo_sriTipoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarcodigo_sriTipoLineaFlujoCaja() {
		return this.mostrarcodigo_sriTipoLineaFlujoCaja;
	}

	public void setMostrarcodigo_sriTipoLineaFlujoCaja(Boolean mostrarcodigo_sriTipoLineaFlujoCaja) {
		this.mostrarcodigo_sriTipoLineaFlujoCaja= mostrarcodigo_sriTipoLineaFlujoCaja;
	}

	public Boolean getActivarcodigo_sriTipoLineaFlujoCaja() {
		return this.activarcodigo_sriTipoLineaFlujoCaja;
	}

	public void setActivarcodigo_sriTipoLineaFlujoCaja(Boolean activarcodigo_sriTipoLineaFlujoCaja) {
		this.activarcodigo_sriTipoLineaFlujoCaja= activarcodigo_sriTipoLineaFlujoCaja;
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
		
		
		this.setMostraridTipoLineaFlujoCaja(esInicial);
		this.setMostrarid_empresaTipoLineaFlujoCaja(esInicial);
		this.setMostrarnombreTipoLineaFlujoCaja(esInicial);
		this.setMostrarcodigo_sriTipoLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI)) {
				this.setMostrarcodigo_sriTipoLineaFlujoCaja(esAsigna);
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
		
		
		this.setActivaridTipoLineaFlujoCaja(esInicial);
		this.setActivarid_empresaTipoLineaFlujoCaja(esInicial);
		this.setActivarnombreTipoLineaFlujoCaja(esInicial);
		this.setActivarcodigo_sriTipoLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI)) {
				this.setActivarcodigo_sriTipoLineaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoLineaFlujoCaja(esInicial);
		this.setResaltarid_empresaTipoLineaFlujoCaja(esInicial);
		this.setResaltarnombreTipoLineaFlujoCaja(esInicial);
		this.setResaltarcodigo_sriTipoLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI)) {
				this.setResaltarcodigo_sriTipoLineaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarLineaFlujoCajaTipoLineaFlujoCaja=null;

	public Border getResaltarLineaFlujoCajaTipoLineaFlujoCaja() {
		return this.resaltarLineaFlujoCajaTipoLineaFlujoCaja;
	}

	public void setResaltarLineaFlujoCajaTipoLineaFlujoCaja(Border borderResaltarLineaFlujoCaja) {
		if(borderResaltarLineaFlujoCaja!=null) {
			this.resaltarLineaFlujoCajaTipoLineaFlujoCaja= borderResaltarLineaFlujoCaja;
		}
	}

	public Border setResaltarLineaFlujoCajaTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltarLineaFlujoCaja=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipolineaflujocajaBeanSwingJInternalFrame.jTtoolBarTipoLineaFlujoCaja.setBorder(borderResaltarLineaFlujoCaja);
			
		this.resaltarLineaFlujoCajaTipoLineaFlujoCaja= borderResaltarLineaFlujoCaja;

		 return borderResaltarLineaFlujoCaja;
	}



	public Boolean mostrarLineaFlujoCajaTipoLineaFlujoCaja=true;

	public Boolean getMostrarLineaFlujoCajaTipoLineaFlujoCaja() {
		return this.mostrarLineaFlujoCajaTipoLineaFlujoCaja;
	}

	public void setMostrarLineaFlujoCajaTipoLineaFlujoCaja(Boolean visibilidadResaltarLineaFlujoCaja) {
		this.mostrarLineaFlujoCajaTipoLineaFlujoCaja= visibilidadResaltarLineaFlujoCaja;
	}



	public Boolean activarLineaFlujoCajaTipoLineaFlujoCaja=true;

	public Boolean gethabilitarResaltarLineaFlujoCajaTipoLineaFlujoCaja() {
		return this.activarLineaFlujoCajaTipoLineaFlujoCaja;
	}

	public void setActivarLineaFlujoCajaTipoLineaFlujoCaja(Boolean habilitarResaltarLineaFlujoCaja) {
		this.activarLineaFlujoCajaTipoLineaFlujoCaja= habilitarResaltarLineaFlujoCaja;
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

		this.setMostrarLineaFlujoCajaTipoLineaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setMostrarLineaFlujoCajaTipoLineaFlujoCaja(esAsigna);
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

		this.setActivarLineaFlujoCajaTipoLineaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setActivarLineaFlujoCajaTipoLineaFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarLineaFlujoCajaTipoLineaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setResaltarLineaFlujoCajaTipoLineaFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoSriTipoLineaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorCodigoSriTipoLineaFlujoCaja() {
		return this.mostrarBusquedaPorCodigoSriTipoLineaFlujoCaja;
	}

	public void setMostrarBusquedaPorCodigoSriTipoLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoSriTipoLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTipoLineaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorIdTipoLineaFlujoCaja() {
		return this.mostrarBusquedaPorIdTipoLineaFlujoCaja;
	}

	public void setMostrarBusquedaPorIdTipoLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoLineaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorNombreTipoLineaFlujoCaja() {
		return this.mostrarBusquedaPorNombreTipoLineaFlujoCaja;
	}

	public void setMostrarBusquedaPorNombreTipoLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoLineaFlujoCaja=true;

	public Boolean getMostrarFK_IdEmpresaTipoLineaFlujoCaja() {
		return this.mostrarFK_IdEmpresaTipoLineaFlujoCaja;
	}

	public void setMostrarFK_IdEmpresaTipoLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoLineaFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoSriTipoLineaFlujoCaja=true;

	public Boolean getActivarBusquedaPorCodigoSriTipoLineaFlujoCaja() {
		return this.activarBusquedaPorCodigoSriTipoLineaFlujoCaja;
	}

	public void setActivarBusquedaPorCodigoSriTipoLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoSriTipoLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTipoLineaFlujoCaja=true;

	public Boolean getActivarBusquedaPorIdTipoLineaFlujoCaja() {
		return this.activarBusquedaPorIdTipoLineaFlujoCaja;
	}

	public void setActivarBusquedaPorIdTipoLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoLineaFlujoCaja=true;

	public Boolean getActivarBusquedaPorNombreTipoLineaFlujoCaja() {
		return this.activarBusquedaPorNombreTipoLineaFlujoCaja;
	}

	public void setActivarBusquedaPorNombreTipoLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoLineaFlujoCaja=true;

	public Boolean getActivarFK_IdEmpresaTipoLineaFlujoCaja() {
		return this.activarFK_IdEmpresaTipoLineaFlujoCaja;
	}

	public void setActivarFK_IdEmpresaTipoLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoLineaFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoSriTipoLineaFlujoCaja=null;

	public Border getResaltarBusquedaPorCodigoSriTipoLineaFlujoCaja() {
		return this.resaltarBusquedaPorCodigoSriTipoLineaFlujoCaja;
	}

	public void setResaltarBusquedaPorCodigoSriTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoSriTipoLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoSriTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoSriTipoLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTipoLineaFlujoCaja=null;

	public Border getResaltarBusquedaPorIdTipoLineaFlujoCaja() {
		return this.resaltarBusquedaPorIdTipoLineaFlujoCaja;
	}

	public void setResaltarBusquedaPorIdTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoLineaFlujoCaja=null;

	public Border getResaltarBusquedaPorNombreTipoLineaFlujoCaja() {
		return this.resaltarBusquedaPorNombreTipoLineaFlujoCaja;
	}

	public void setResaltarBusquedaPorNombreTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoLineaFlujoCaja=null;

	public Border getResaltarFK_IdEmpresaTipoLineaFlujoCaja() {
		return this.resaltarFK_IdEmpresaTipoLineaFlujoCaja;
	}

	public void setResaltarFK_IdEmpresaTipoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLineaFlujoCajaBeanSwingJInternalFrame tipolineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoLineaFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}