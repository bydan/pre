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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoCargoLaboConstantesFunciones;
import com.bydan.erp.cartera.util.TipoCargoLaboParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoCargoLaboParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCargoLaboConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCargoLabo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCargoLabo"+TipoCargoLaboConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCargoLaboHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCargoLaboHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCargoLaboConstantesFunciones.SCHEMA+"_"+TipoCargoLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCargoLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCargoLaboConstantesFunciones.SCHEMA+"_"+TipoCargoLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCargoLaboConstantesFunciones.SCHEMA+"_"+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCargoLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCargoLaboConstantesFunciones.SCHEMA+"_"+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCargoLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCargoLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargoLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCargoLaboConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCargoLaboConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCargoLaboConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCargoLaboConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cargo Laborals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cargo Laboral";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cargo Labo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCargoLabo";
	public static final String OBJECTNAME="tipocargolabo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_cargo_labo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocargolabo from "+TipoCargoLaboConstantesFunciones.SPERSISTENCENAME+" tipocargolabo";
	public static String QUERYSELECTNATIVE="select "+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME+".id,"+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME+".version_row,"+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME+".id_empresa,"+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME+".codigo,"+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME+".nombre from "+TipoCargoLaboConstantesFunciones.SCHEMA+"."+TipoCargoLaboConstantesFunciones.TABLENAME;//+" as "+TipoCargoLaboConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCargoLaboLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCargoLaboConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCargoLaboConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCargoLaboConstantesFunciones.CODIGO)) {sLabelColumna=TipoCargoLaboConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCargoLaboConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCargoLaboConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoCargoLaboDescripcion(TipoCargoLabo tipocargolabo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocargolabo !=null/* && tipocargolabo.getId()!=0*/) {
			sDescripcion=tipocargolabo.getcodigo();//tipocargolabotipocargolabo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCargoLaboDescripcionDetallado(TipoCargoLabo tipocargolabo) {
		String sDescripcion="";
			
		sDescripcion+=TipoCargoLaboConstantesFunciones.ID+"=";
		sDescripcion+=tipocargolabo.getId().toString()+",";
		sDescripcion+=TipoCargoLaboConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocargolabo.getVersionRow().toString()+",";
		sDescripcion+=TipoCargoLaboConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocargolabo.getid_empresa().toString()+",";
		sDescripcion+=TipoCargoLaboConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocargolabo.getcodigo()+",";
		sDescripcion+=TipoCargoLaboConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocargolabo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCargoLaboDescripcion(TipoCargoLabo tipocargolabo,String sValor) throws Exception {			
		if(tipocargolabo !=null) {
			tipocargolabo.setcodigo(sValor);;//tipocargolabotipocargolabo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCargoLabo(TipoCargoLabo tipocargolabo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocargolabo.setcodigo(tipocargolabo.getcodigo().trim());
		tipocargolabo.setnombre(tipocargolabo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCargoLabos(List<TipoCargoLabo> tipocargolabos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCargoLabo tipocargolabo: tipocargolabos) {
			tipocargolabo.setcodigo(tipocargolabo.getcodigo().trim());
			tipocargolabo.setnombre(tipocargolabo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCargoLabo(TipoCargoLabo tipocargolabo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocargolabo.getConCambioAuxiliar()) {
			tipocargolabo.setIsDeleted(tipocargolabo.getIsDeletedAuxiliar());	
			tipocargolabo.setIsNew(tipocargolabo.getIsNewAuxiliar());	
			tipocargolabo.setIsChanged(tipocargolabo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocargolabo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocargolabo.setIsDeletedAuxiliar(false);	
			tipocargolabo.setIsNewAuxiliar(false);	
			tipocargolabo.setIsChangedAuxiliar(false);
			
			tipocargolabo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCargoLabos(List<TipoCargoLabo> tipocargolabos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCargoLabo tipocargolabo : tipocargolabos) {
			if(conAsignarBase && tipocargolabo.getConCambioAuxiliar()) {
				tipocargolabo.setIsDeleted(tipocargolabo.getIsDeletedAuxiliar());	
				tipocargolabo.setIsNew(tipocargolabo.getIsNewAuxiliar());	
				tipocargolabo.setIsChanged(tipocargolabo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocargolabo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocargolabo.setIsDeletedAuxiliar(false);	
				tipocargolabo.setIsNewAuxiliar(false);	
				tipocargolabo.setIsChangedAuxiliar(false);
				
				tipocargolabo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCargoLabo(TipoCargoLabo tipocargolabo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCargoLabos(List<TipoCargoLabo> tipocargolabos,Boolean conEnteros) throws Exception  {
		
		for(TipoCargoLabo tipocargolabo: tipocargolabos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCargoLabo(List<TipoCargoLabo> tipocargolabos,TipoCargoLabo tipocargolaboAux) throws Exception  {
		TipoCargoLaboConstantesFunciones.InicializarValoresTipoCargoLabo(tipocargolaboAux,true);
		
		for(TipoCargoLabo tipocargolabo: tipocargolabos) {
			if(tipocargolabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCargoLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCargoLaboConstantesFunciones.getArrayColumnasGlobalesTipoCargoLabo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCargoLabo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCargoLaboConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCargoLaboConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCargoLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCargoLabo> tipocargolabos,TipoCargoLabo tipocargolabo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCargoLabo tipocargolaboAux: tipocargolabos) {
			if(tipocargolaboAux!=null && tipocargolabo!=null) {
				if((tipocargolaboAux.getId()==null && tipocargolabo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocargolaboAux.getId()!=null && tipocargolabo.getId()!=null){
					if(tipocargolaboAux.getId().equals(tipocargolabo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCargoLabo(List<TipoCargoLabo> tipocargolabos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCargoLabo tipocargolabo: tipocargolabos) {			
			if(tipocargolabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCargoLabo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCargoLaboConstantesFunciones.LABEL_ID, TipoCargoLaboConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargoLaboConstantesFunciones.LABEL_VERSIONROW, TipoCargoLaboConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargoLaboConstantesFunciones.LABEL_IDEMPRESA, TipoCargoLaboConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargoLaboConstantesFunciones.LABEL_CODIGO, TipoCargoLaboConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargoLaboConstantesFunciones.LABEL_NOMBRE, TipoCargoLaboConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCargoLabo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCargoLaboConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargoLaboConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargoLaboConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargoLaboConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargoLaboConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargoLabo() throws Exception  {
		return TipoCargoLaboConstantesFunciones.getTiposSeleccionarTipoCargoLabo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargoLabo(Boolean conFk) throws Exception  {
		return TipoCargoLaboConstantesFunciones.getTiposSeleccionarTipoCargoLabo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargoLabo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCargoLaboConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCargoLaboConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCargoLaboConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCargoLaboConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCargoLaboConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCargoLaboConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCargoLabo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCargoLabo(TipoCargoLabo tipocargolaboAux) throws Exception {
		
			tipocargolaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocargolaboAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCargoLabo(List<TipoCargoLabo> tipocargolabosTemp) throws Exception {
		for(TipoCargoLabo tipocargolaboAux:tipocargolabosTemp) {
			
			tipocargolaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocargolaboAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCargoLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCargoLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCargoLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCargoLaboConstantesFunciones.getClassesRelationshipsOfTipoCargoLabo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCargoLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(InformacionLaboral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionLaboral.class)) {
						classes.add(new Classe(InformacionLaboral.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCargoLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCargoLaboConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCargoLabo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCargoLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
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
	public static void actualizarLista(TipoCargoLabo tipocargolabo,List<TipoCargoLabo> tipocargolabos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCargoLabo tipocargolaboEncontrado=null;
			
			for(TipoCargoLabo tipocargolaboLocal:tipocargolabos) {
				if(tipocargolaboLocal.getId().equals(tipocargolabo.getId())) {
					tipocargolaboEncontrado=tipocargolaboLocal;
					
					tipocargolaboLocal.setIsChanged(tipocargolabo.getIsChanged());
					tipocargolaboLocal.setIsNew(tipocargolabo.getIsNew());
					tipocargolaboLocal.setIsDeleted(tipocargolabo.getIsDeleted());
					
					tipocargolaboLocal.setGeneralEntityOriginal(tipocargolabo.getGeneralEntityOriginal());
					
					tipocargolaboLocal.setId(tipocargolabo.getId());	
					tipocargolaboLocal.setVersionRow(tipocargolabo.getVersionRow());	
					tipocargolaboLocal.setid_empresa(tipocargolabo.getid_empresa());	
					tipocargolaboLocal.setcodigo(tipocargolabo.getcodigo());	
					tipocargolaboLocal.setnombre(tipocargolabo.getnombre());	
					
					
					tipocargolaboLocal.setClientes(tipocargolabo.getClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocargolabo.getIsDeleted()) {
				if(!existe) {
					tipocargolabos.add(tipocargolabo);
				}
			} else {
				if(tipocargolaboEncontrado!=null && permiteQuitar)  {
					tipocargolabos.remove(tipocargolaboEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCargoLabo tipocargolabo,List<TipoCargoLabo> tipocargolabos) throws Exception {
		try	{			
			for(TipoCargoLabo tipocargolaboLocal:tipocargolabos) {
				if(tipocargolaboLocal.getId().equals(tipocargolabo.getId())) {
					tipocargolaboLocal.setIsSelected(tipocargolabo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCargoLabo(List<TipoCargoLabo> tipocargolabosAux) throws Exception {
		//this.tipocargolabosAux=tipocargolabosAux;
		
		for(TipoCargoLabo tipocargolaboAux:tipocargolabosAux) {
			if(tipocargolaboAux.getIsChanged()) {
				tipocargolaboAux.setIsChanged(false);
			}		
			
			if(tipocargolaboAux.getIsNew()) {
				tipocargolaboAux.setIsNew(false);
			}	
			
			if(tipocargolaboAux.getIsDeleted()) {
				tipocargolaboAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCargoLabo(TipoCargoLabo tipocargolaboAux) throws Exception {
		//this.tipocargolaboAux=tipocargolaboAux;
		
			if(tipocargolaboAux.getIsChanged()) {
				tipocargolaboAux.setIsChanged(false);
			}		
			
			if(tipocargolaboAux.getIsNew()) {
				tipocargolaboAux.setIsNew(false);
			}	
			
			if(tipocargolaboAux.getIsDeleted()) {
				tipocargolaboAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCargoLabo tipocargolaboAsignar,TipoCargoLabo tipocargolabo) throws Exception {
		tipocargolaboAsignar.setId(tipocargolabo.getId());	
		tipocargolaboAsignar.setVersionRow(tipocargolabo.getVersionRow());	
		tipocargolaboAsignar.setid_empresa(tipocargolabo.getid_empresa());
		tipocargolaboAsignar.setempresa_descripcion(tipocargolabo.getempresa_descripcion());	
		tipocargolaboAsignar.setcodigo(tipocargolabo.getcodigo());	
		tipocargolaboAsignar.setnombre(tipocargolabo.getnombre());	
	}
	
	public static void inicializarTipoCargoLabo(TipoCargoLabo tipocargolabo) throws Exception {
		try {
				tipocargolabo.setId(0L);	
					
				tipocargolabo.setid_empresa(-1L);	
				tipocargolabo.setcodigo("");	
				tipocargolabo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCargoLabo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCargoLaboConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCargoLaboConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCargoLaboConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCargoLabo(String sTipo,Row row,Workbook workbook,TipoCargoLabo tipocargolabo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocargolabo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocargolabo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocargolabo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCargoLabo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCargoLabo() {
		return this.sFinalQueryTipoCargoLabo;
	}
	
	public void setsFinalQueryTipoCargoLabo(String sFinalQueryTipoCargoLabo) {
		this.sFinalQueryTipoCargoLabo= sFinalQueryTipoCargoLabo;
	}
	
	public Border resaltarSeleccionarTipoCargoLabo=null;
	
	public Border setResaltarSeleccionarTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCargoLabo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCargoLabo() {
		return this.resaltarSeleccionarTipoCargoLabo;
	}
	
	public void setResaltarSeleccionarTipoCargoLabo(Border borderResaltarSeleccionarTipoCargoLabo) {
		this.resaltarSeleccionarTipoCargoLabo= borderResaltarSeleccionarTipoCargoLabo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCargoLabo=null;
	public Boolean mostraridTipoCargoLabo=true;
	public Boolean activaridTipoCargoLabo=true;

	public Border resaltarid_empresaTipoCargoLabo=null;
	public Boolean mostrarid_empresaTipoCargoLabo=true;
	public Boolean activarid_empresaTipoCargoLabo=true;
	public Boolean cargarid_empresaTipoCargoLabo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCargoLabo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCargoLabo=null;
	public Boolean mostrarcodigoTipoCargoLabo=true;
	public Boolean activarcodigoTipoCargoLabo=true;

	public Border resaltarnombreTipoCargoLabo=null;
	public Boolean mostrarnombreTipoCargoLabo=true;
	public Boolean activarnombreTipoCargoLabo=true;

	
	

	public Border setResaltaridTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltar);
		
		this.resaltaridTipoCargoLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCargoLabo() {
		return this.resaltaridTipoCargoLabo;
	}

	public void setResaltaridTipoCargoLabo(Border borderResaltar) {
		this.resaltaridTipoCargoLabo= borderResaltar;
	}

	public Boolean getMostraridTipoCargoLabo() {
		return this.mostraridTipoCargoLabo;
	}

	public void setMostraridTipoCargoLabo(Boolean mostraridTipoCargoLabo) {
		this.mostraridTipoCargoLabo= mostraridTipoCargoLabo;
	}

	public Boolean getActivaridTipoCargoLabo() {
		return this.activaridTipoCargoLabo;
	}

	public void setActivaridTipoCargoLabo(Boolean activaridTipoCargoLabo) {
		this.activaridTipoCargoLabo= activaridTipoCargoLabo;
	}

	public Border setResaltarid_empresaTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCargoLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCargoLabo() {
		return this.resaltarid_empresaTipoCargoLabo;
	}

	public void setResaltarid_empresaTipoCargoLabo(Border borderResaltar) {
		this.resaltarid_empresaTipoCargoLabo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCargoLabo() {
		return this.mostrarid_empresaTipoCargoLabo;
	}

	public void setMostrarid_empresaTipoCargoLabo(Boolean mostrarid_empresaTipoCargoLabo) {
		this.mostrarid_empresaTipoCargoLabo= mostrarid_empresaTipoCargoLabo;
	}

	public Boolean getActivarid_empresaTipoCargoLabo() {
		return this.activarid_empresaTipoCargoLabo;
	}

	public void setActivarid_empresaTipoCargoLabo(Boolean activarid_empresaTipoCargoLabo) {
		this.activarid_empresaTipoCargoLabo= activarid_empresaTipoCargoLabo;
	}

	public Boolean getCargarid_empresaTipoCargoLabo() {
		return this.cargarid_empresaTipoCargoLabo;
	}

	public void setCargarid_empresaTipoCargoLabo(Boolean cargarid_empresaTipoCargoLabo) {
		this.cargarid_empresaTipoCargoLabo= cargarid_empresaTipoCargoLabo;
	}

	public Border setResaltarcodigoTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCargoLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCargoLabo() {
		return this.resaltarcodigoTipoCargoLabo;
	}

	public void setResaltarcodigoTipoCargoLabo(Border borderResaltar) {
		this.resaltarcodigoTipoCargoLabo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCargoLabo() {
		return this.mostrarcodigoTipoCargoLabo;
	}

	public void setMostrarcodigoTipoCargoLabo(Boolean mostrarcodigoTipoCargoLabo) {
		this.mostrarcodigoTipoCargoLabo= mostrarcodigoTipoCargoLabo;
	}

	public Boolean getActivarcodigoTipoCargoLabo() {
		return this.activarcodigoTipoCargoLabo;
	}

	public void setActivarcodigoTipoCargoLabo(Boolean activarcodigoTipoCargoLabo) {
		this.activarcodigoTipoCargoLabo= activarcodigoTipoCargoLabo;
	}

	public Border setResaltarnombreTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCargoLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCargoLabo() {
		return this.resaltarnombreTipoCargoLabo;
	}

	public void setResaltarnombreTipoCargoLabo(Border borderResaltar) {
		this.resaltarnombreTipoCargoLabo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCargoLabo() {
		return this.mostrarnombreTipoCargoLabo;
	}

	public void setMostrarnombreTipoCargoLabo(Boolean mostrarnombreTipoCargoLabo) {
		this.mostrarnombreTipoCargoLabo= mostrarnombreTipoCargoLabo;
	}

	public Boolean getActivarnombreTipoCargoLabo() {
		return this.activarnombreTipoCargoLabo;
	}

	public void setActivarnombreTipoCargoLabo(Boolean activarnombreTipoCargoLabo) {
		this.activarnombreTipoCargoLabo= activarnombreTipoCargoLabo;
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
		
		
		this.setMostraridTipoCargoLabo(esInicial);
		this.setMostrarid_empresaTipoCargoLabo(esInicial);
		this.setMostrarcodigoTipoCargoLabo(esInicial);
		this.setMostrarnombreTipoCargoLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.ID)) {
				this.setMostraridTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCargoLabo(esAsigna);
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
		
		
		this.setActivaridTipoCargoLabo(esInicial);
		this.setActivarid_empresaTipoCargoLabo(esInicial);
		this.setActivarcodigoTipoCargoLabo(esInicial);
		this.setActivarnombreTipoCargoLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.ID)) {
				this.setActivaridTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCargoLabo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCargoLabo(esInicial);
		this.setResaltarid_empresaTipoCargoLabo(esInicial);
		this.setResaltarcodigoTipoCargoLabo(esInicial);
		this.setResaltarnombreTipoCargoLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.ID)) {
				this.setResaltaridTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCargoLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargoLaboConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCargoLabo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTipoCargoLabo=null;

	public Border getResaltarClienteTipoCargoLabo() {
		return this.resaltarClienteTipoCargoLabo;
	}

	public void setResaltarClienteTipoCargoLabo(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoCargoLabo= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocargolaboBeanSwingJInternalFrame.jTtoolBarTipoCargoLabo.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoCargoLabo= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoCargoLabo=true;

	public Boolean getMostrarClienteTipoCargoLabo() {
		return this.mostrarClienteTipoCargoLabo;
	}

	public void setMostrarClienteTipoCargoLabo(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoCargoLabo= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoCargoLabo=true;

	public Boolean gethabilitarResaltarClienteTipoCargoLabo() {
		return this.activarClienteTipoCargoLabo;
	}

	public void setActivarClienteTipoCargoLabo(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoCargoLabo= habilitarResaltarCliente;
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

		this.setMostrarClienteTipoCargoLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoCargoLabo(esAsigna);
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

		this.setActivarClienteTipoCargoLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoCargoLabo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTipoCargoLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoCargoLabo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoCargoLabo=true;

	public Boolean getMostrarBusquedaPorCodigoTipoCargoLabo() {
		return this.mostrarBusquedaPorCodigoTipoCargoLabo;
	}

	public void setMostrarBusquedaPorCodigoTipoCargoLabo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoCargoLabo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoCargoLabo=true;

	public Boolean getMostrarBusquedaPorNombreTipoCargoLabo() {
		return this.mostrarBusquedaPorNombreTipoCargoLabo;
	}

	public void setMostrarBusquedaPorNombreTipoCargoLabo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoCargoLabo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoCargoLabo=true;

	public Boolean getMostrarFK_IdEmpresaTipoCargoLabo() {
		return this.mostrarFK_IdEmpresaTipoCargoLabo;
	}

	public void setMostrarFK_IdEmpresaTipoCargoLabo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCargoLabo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoCargoLabo=true;

	public Boolean getActivarBusquedaPorCodigoTipoCargoLabo() {
		return this.activarBusquedaPorCodigoTipoCargoLabo;
	}

	public void setActivarBusquedaPorCodigoTipoCargoLabo(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoCargoLabo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoCargoLabo=true;

	public Boolean getActivarBusquedaPorNombreTipoCargoLabo() {
		return this.activarBusquedaPorNombreTipoCargoLabo;
	}

	public void setActivarBusquedaPorNombreTipoCargoLabo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoCargoLabo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoCargoLabo=true;

	public Boolean getActivarFK_IdEmpresaTipoCargoLabo() {
		return this.activarFK_IdEmpresaTipoCargoLabo;
	}

	public void setActivarFK_IdEmpresaTipoCargoLabo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCargoLabo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoCargoLabo=null;

	public Border getResaltarBusquedaPorCodigoTipoCargoLabo() {
		return this.resaltarBusquedaPorCodigoTipoCargoLabo;
	}

	public void setResaltarBusquedaPorCodigoTipoCargoLabo(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoCargoLabo= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoCargoLabo= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoCargoLabo=null;

	public Border getResaltarBusquedaPorNombreTipoCargoLabo() {
		return this.resaltarBusquedaPorNombreTipoCargoLabo;
	}

	public void setResaltarBusquedaPorNombreTipoCargoLabo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoCargoLabo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoCargoLabo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoCargoLabo=null;

	public Border getResaltarFK_IdEmpresaTipoCargoLabo() {
		return this.resaltarFK_IdEmpresaTipoCargoLabo;
	}

	public void setResaltarFK_IdEmpresaTipoCargoLabo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCargoLabo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCargoLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargoLaboBeanSwingJInternalFrame tipocargolaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCargoLabo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}