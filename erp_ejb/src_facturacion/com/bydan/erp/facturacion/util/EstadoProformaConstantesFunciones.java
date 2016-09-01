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


import com.bydan.erp.facturacion.util.EstadoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoProformaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoProforma"+EstadoProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoProformaConstantesFunciones.SCHEMA+"_"+EstadoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoProformaConstantesFunciones.SCHEMA+"_"+EstadoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoProformaConstantesFunciones.SCHEMA+"_"+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoProformaConstantesFunciones.SCHEMA+"_"+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Estado Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoProforma";
	public static final String OBJECTNAME="estadoproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoproforma from "+EstadoProformaConstantesFunciones.SPERSISTENCENAME+" estadoproforma";
	public static String QUERYSELECTNATIVE="select "+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".id,"+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".version_row,"+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".id_empresa,"+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".codigo,"+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".nombre,"+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME+".id_color_general from "+EstadoProformaConstantesFunciones.SCHEMA+"."+EstadoProformaConstantesFunciones.TABLENAME;//+" as "+EstadoProformaConstantesFunciones.TABLENAME;
	
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
    public static final String IDCOLORGENERAL= "id_color_general";
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
    	public static final String LABEL_IDCOLORGENERAL= "Idcolor General";
		public static final String LABEL_IDCOLORGENERAL_LOWER= "Color General";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadoProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadoProformaConstantesFunciones.CODIGO)) {sLabelColumna=EstadoProformaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoProformaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoProformaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoProformaConstantesFunciones.IDCOLORGENERAL)) {sLabelColumna=EstadoProformaConstantesFunciones.LABEL_IDCOLORGENERAL;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEstadoProformaDescripcion(EstadoProforma estadoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoproforma !=null/* && estadoproforma.getId()!=0*/) {
			sDescripcion=estadoproforma.getcodigo();//estadoproformaestadoproforma.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoProformaDescripcionDetallado(EstadoProforma estadoproforma) {
		String sDescripcion="";
			
		sDescripcion+=EstadoProformaConstantesFunciones.ID+"=";
		sDescripcion+=estadoproforma.getId().toString()+",";
		sDescripcion+=EstadoProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoproforma.getVersionRow().toString()+",";
		sDescripcion+=EstadoProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadoproforma.getid_empresa().toString()+",";
		sDescripcion+=EstadoProformaConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoproforma.getcodigo()+",";
		sDescripcion+=EstadoProformaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoproforma.getnombre()+",";
		sDescripcion+=EstadoProformaConstantesFunciones.IDCOLORGENERAL+"=";
		sDescripcion+=estadoproforma.getid_color_general().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoProformaDescripcion(EstadoProforma estadoproforma,String sValor) throws Exception {			
		if(estadoproforma !=null) {
			estadoproforma.setcodigo(sValor);;//estadoproformaestadoproforma.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
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
			sNombreIndice="Tipo=  Por Idcolor General";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdColorGeneral(Long id_color_general) {
		String sDetalleIndice=" Parametros->";
		if(id_color_general!=null) {sDetalleIndice+=" Codigo Unico De Idcolor General="+id_color_general.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoProforma(EstadoProforma estadoproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoproforma.setcodigo(estadoproforma.getcodigo().trim());
		estadoproforma.setnombre(estadoproforma.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoProformas(List<EstadoProforma> estadoproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoProforma estadoproforma: estadoproformas) {
			estadoproforma.setcodigo(estadoproforma.getcodigo().trim());
			estadoproforma.setnombre(estadoproforma.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoProforma(EstadoProforma estadoproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoproforma.getConCambioAuxiliar()) {
			estadoproforma.setIsDeleted(estadoproforma.getIsDeletedAuxiliar());	
			estadoproforma.setIsNew(estadoproforma.getIsNewAuxiliar());	
			estadoproforma.setIsChanged(estadoproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoproforma.setIsDeletedAuxiliar(false);	
			estadoproforma.setIsNewAuxiliar(false);	
			estadoproforma.setIsChangedAuxiliar(false);
			
			estadoproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoProformas(List<EstadoProforma> estadoproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoProforma estadoproforma : estadoproformas) {
			if(conAsignarBase && estadoproforma.getConCambioAuxiliar()) {
				estadoproforma.setIsDeleted(estadoproforma.getIsDeletedAuxiliar());	
				estadoproforma.setIsNew(estadoproforma.getIsNewAuxiliar());	
				estadoproforma.setIsChanged(estadoproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoproforma.setIsDeletedAuxiliar(false);	
				estadoproforma.setIsNewAuxiliar(false);	
				estadoproforma.setIsChangedAuxiliar(false);
				
				estadoproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoProforma(EstadoProforma estadoproforma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoProformas(List<EstadoProforma> estadoproformas,Boolean conEnteros) throws Exception  {
		
		for(EstadoProforma estadoproforma: estadoproformas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoProforma(List<EstadoProforma> estadoproformas,EstadoProforma estadoproformaAux) throws Exception  {
		EstadoProformaConstantesFunciones.InicializarValoresEstadoProforma(estadoproformaAux,true);
		
		for(EstadoProforma estadoproforma: estadoproformas) {
			if(estadoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoProformaConstantesFunciones.getArrayColumnasGlobalesEstadoProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadoProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadoProformaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoProforma> estadoproformas,EstadoProforma estadoproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoProforma estadoproformaAux: estadoproformas) {
			if(estadoproformaAux!=null && estadoproforma!=null) {
				if((estadoproformaAux.getId()==null && estadoproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoproformaAux.getId()!=null && estadoproforma.getId()!=null){
					if(estadoproformaAux.getId().equals(estadoproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoProforma(List<EstadoProforma> estadoproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoProforma estadoproforma: estadoproformas) {			
			if(estadoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_ID, EstadoProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_VERSIONROW, EstadoProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_IDEMPRESA, EstadoProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_CODIGO, EstadoProformaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_NOMBRE, EstadoProformaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoProformaConstantesFunciones.LABEL_IDCOLORGENERAL, EstadoProformaConstantesFunciones.IDCOLORGENERAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoProformaConstantesFunciones.IDCOLORGENERAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoProforma() throws Exception  {
		return EstadoProformaConstantesFunciones.getTiposSeleccionarEstadoProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoProforma(Boolean conFk) throws Exception  {
		return EstadoProformaConstantesFunciones.getTiposSeleccionarEstadoProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadoProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoProformaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoProformaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoProformaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoProformaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoProformaConstantesFunciones.LABEL_IDCOLORGENERAL);
			reporte.setsDescripcion(EstadoProformaConstantesFunciones.LABEL_IDCOLORGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoProforma(EstadoProforma estadoproformaAux) throws Exception {
		
			estadoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadoproformaAux.getEmpresa()));
			estadoproformaAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadoproformaAux.getColorGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoProforma(List<EstadoProforma> estadoproformasTemp) throws Exception {
		for(EstadoProforma estadoproformaAux:estadoproformasTemp) {
			
			estadoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadoproformaAux.getEmpresa()));
			estadoproformaAux.setcolorgeneral_descripcion(ColorGeneralConstantesFunciones.getColorGeneralDescripcion(estadoproformaAux.getColorGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ColorGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ColorGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoProformaConstantesFunciones.getClassesRelationshipsOfEstadoProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Proforma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoProformaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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
	public static void actualizarLista(EstadoProforma estadoproforma,List<EstadoProforma> estadoproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoProforma estadoproformaEncontrado=null;
			
			for(EstadoProforma estadoproformaLocal:estadoproformas) {
				if(estadoproformaLocal.getId().equals(estadoproforma.getId())) {
					estadoproformaEncontrado=estadoproformaLocal;
					
					estadoproformaLocal.setIsChanged(estadoproforma.getIsChanged());
					estadoproformaLocal.setIsNew(estadoproforma.getIsNew());
					estadoproformaLocal.setIsDeleted(estadoproforma.getIsDeleted());
					
					estadoproformaLocal.setGeneralEntityOriginal(estadoproforma.getGeneralEntityOriginal());
					
					estadoproformaLocal.setId(estadoproforma.getId());	
					estadoproformaLocal.setVersionRow(estadoproforma.getVersionRow());	
					estadoproformaLocal.setid_empresa(estadoproforma.getid_empresa());	
					estadoproformaLocal.setcodigo(estadoproforma.getcodigo());	
					estadoproformaLocal.setnombre(estadoproforma.getnombre());	
					estadoproformaLocal.setid_color_general(estadoproforma.getid_color_general());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadoproforma.getIsDeleted()) {
				if(!existe) {
					estadoproformas.add(estadoproforma);
				}
			} else {
				if(estadoproformaEncontrado!=null && permiteQuitar)  {
					estadoproformas.remove(estadoproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoProforma estadoproforma,List<EstadoProforma> estadoproformas) throws Exception {
		try	{			
			for(EstadoProforma estadoproformaLocal:estadoproformas) {
				if(estadoproformaLocal.getId().equals(estadoproforma.getId())) {
					estadoproformaLocal.setIsSelected(estadoproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoProforma(List<EstadoProforma> estadoproformasAux) throws Exception {
		//this.estadoproformasAux=estadoproformasAux;
		
		for(EstadoProforma estadoproformaAux:estadoproformasAux) {
			if(estadoproformaAux.getIsChanged()) {
				estadoproformaAux.setIsChanged(false);
			}		
			
			if(estadoproformaAux.getIsNew()) {
				estadoproformaAux.setIsNew(false);
			}	
			
			if(estadoproformaAux.getIsDeleted()) {
				estadoproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoProforma(EstadoProforma estadoproformaAux) throws Exception {
		//this.estadoproformaAux=estadoproformaAux;
		
			if(estadoproformaAux.getIsChanged()) {
				estadoproformaAux.setIsChanged(false);
			}		
			
			if(estadoproformaAux.getIsNew()) {
				estadoproformaAux.setIsNew(false);
			}	
			
			if(estadoproformaAux.getIsDeleted()) {
				estadoproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoProforma estadoproformaAsignar,EstadoProforma estadoproforma) throws Exception {
		estadoproformaAsignar.setId(estadoproforma.getId());	
		estadoproformaAsignar.setVersionRow(estadoproforma.getVersionRow());	
		estadoproformaAsignar.setid_empresa(estadoproforma.getid_empresa());
		estadoproformaAsignar.setempresa_descripcion(estadoproforma.getempresa_descripcion());	
		estadoproformaAsignar.setcodigo(estadoproforma.getcodigo());	
		estadoproformaAsignar.setnombre(estadoproforma.getnombre());	
		estadoproformaAsignar.setid_color_general(estadoproforma.getid_color_general());
		estadoproformaAsignar.setcolorgeneral_descripcion(estadoproforma.getcolorgeneral_descripcion());	
	}
	
	public static void inicializarEstadoProforma(EstadoProforma estadoproforma) throws Exception {
		try {
				estadoproforma.setId(0L);	
					
				estadoproforma.setid_empresa(-1L);	
				estadoproforma.setcodigo("");	
				estadoproforma.setnombre("");	
				estadoproforma.setid_color_general(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoProformaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoProformaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoProformaConstantesFunciones.LABEL_IDCOLORGENERAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoProforma(String sTipo,Row row,Workbook workbook,EstadoProforma estadoproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoproforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoproforma.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoproforma.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoproforma.getcolorgeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoProforma() {
		return this.sFinalQueryEstadoProforma;
	}
	
	public void setsFinalQueryEstadoProforma(String sFinalQueryEstadoProforma) {
		this.sFinalQueryEstadoProforma= sFinalQueryEstadoProforma;
	}
	
	public Border resaltarSeleccionarEstadoProforma=null;
	
	public Border setResaltarSeleccionarEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoProforma() {
		return this.resaltarSeleccionarEstadoProforma;
	}
	
	public void setResaltarSeleccionarEstadoProforma(Border borderResaltarSeleccionarEstadoProforma) {
		this.resaltarSeleccionarEstadoProforma= borderResaltarSeleccionarEstadoProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoProforma=null;
	public Boolean mostraridEstadoProforma=true;
	public Boolean activaridEstadoProforma=true;

	public Border resaltarid_empresaEstadoProforma=null;
	public Boolean mostrarid_empresaEstadoProforma=true;
	public Boolean activarid_empresaEstadoProforma=true;
	public Boolean cargarid_empresaEstadoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadoProforma=false;//ConEventDepend=true

	public Border resaltarcodigoEstadoProforma=null;
	public Boolean mostrarcodigoEstadoProforma=true;
	public Boolean activarcodigoEstadoProforma=true;

	public Border resaltarnombreEstadoProforma=null;
	public Boolean mostrarnombreEstadoProforma=true;
	public Boolean activarnombreEstadoProforma=true;

	public Border resaltarid_color_generalEstadoProforma=null;
	public Boolean mostrarid_color_generalEstadoProforma=true;
	public Boolean activarid_color_generalEstadoProforma=true;
	public Boolean cargarid_color_generalEstadoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_color_generalEstadoProforma=false;//ConEventDepend=true

	
	

	public Border setResaltaridEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltaridEstadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoProforma() {
		return this.resaltaridEstadoProforma;
	}

	public void setResaltaridEstadoProforma(Border borderResaltar) {
		this.resaltaridEstadoProforma= borderResaltar;
	}

	public Boolean getMostraridEstadoProforma() {
		return this.mostraridEstadoProforma;
	}

	public void setMostraridEstadoProforma(Boolean mostraridEstadoProforma) {
		this.mostraridEstadoProforma= mostraridEstadoProforma;
	}

	public Boolean getActivaridEstadoProforma() {
		return this.activaridEstadoProforma;
	}

	public void setActivaridEstadoProforma(Boolean activaridEstadoProforma) {
		this.activaridEstadoProforma= activaridEstadoProforma;
	}

	public Border setResaltarid_empresaEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadoProforma() {
		return this.resaltarid_empresaEstadoProforma;
	}

	public void setResaltarid_empresaEstadoProforma(Border borderResaltar) {
		this.resaltarid_empresaEstadoProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadoProforma() {
		return this.mostrarid_empresaEstadoProforma;
	}

	public void setMostrarid_empresaEstadoProforma(Boolean mostrarid_empresaEstadoProforma) {
		this.mostrarid_empresaEstadoProforma= mostrarid_empresaEstadoProforma;
	}

	public Boolean getActivarid_empresaEstadoProforma() {
		return this.activarid_empresaEstadoProforma;
	}

	public void setActivarid_empresaEstadoProforma(Boolean activarid_empresaEstadoProforma) {
		this.activarid_empresaEstadoProforma= activarid_empresaEstadoProforma;
	}

	public Boolean getCargarid_empresaEstadoProforma() {
		return this.cargarid_empresaEstadoProforma;
	}

	public void setCargarid_empresaEstadoProforma(Boolean cargarid_empresaEstadoProforma) {
		this.cargarid_empresaEstadoProforma= cargarid_empresaEstadoProforma;
	}

	public Border setResaltarcodigoEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoProforma() {
		return this.resaltarcodigoEstadoProforma;
	}

	public void setResaltarcodigoEstadoProforma(Border borderResaltar) {
		this.resaltarcodigoEstadoProforma= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoProforma() {
		return this.mostrarcodigoEstadoProforma;
	}

	public void setMostrarcodigoEstadoProforma(Boolean mostrarcodigoEstadoProforma) {
		this.mostrarcodigoEstadoProforma= mostrarcodigoEstadoProforma;
	}

	public Boolean getActivarcodigoEstadoProforma() {
		return this.activarcodigoEstadoProforma;
	}

	public void setActivarcodigoEstadoProforma(Boolean activarcodigoEstadoProforma) {
		this.activarcodigoEstadoProforma= activarcodigoEstadoProforma;
	}

	public Border setResaltarnombreEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoProforma() {
		return this.resaltarnombreEstadoProforma;
	}

	public void setResaltarnombreEstadoProforma(Border borderResaltar) {
		this.resaltarnombreEstadoProforma= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoProforma() {
		return this.mostrarnombreEstadoProforma;
	}

	public void setMostrarnombreEstadoProforma(Boolean mostrarnombreEstadoProforma) {
		this.mostrarnombreEstadoProforma= mostrarnombreEstadoProforma;
	}

	public Boolean getActivarnombreEstadoProforma() {
		return this.activarnombreEstadoProforma;
	}

	public void setActivarnombreEstadoProforma(Boolean activarnombreEstadoProforma) {
		this.activarnombreEstadoProforma= activarnombreEstadoProforma;
	}

	public Border setResaltarid_color_generalEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoproformaBeanSwingJInternalFrame.jTtoolBarEstadoProforma.setBorder(borderResaltar);
		
		this.resaltarid_color_generalEstadoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_color_generalEstadoProforma() {
		return this.resaltarid_color_generalEstadoProforma;
	}

	public void setResaltarid_color_generalEstadoProforma(Border borderResaltar) {
		this.resaltarid_color_generalEstadoProforma= borderResaltar;
	}

	public Boolean getMostrarid_color_generalEstadoProforma() {
		return this.mostrarid_color_generalEstadoProforma;
	}

	public void setMostrarid_color_generalEstadoProforma(Boolean mostrarid_color_generalEstadoProforma) {
		this.mostrarid_color_generalEstadoProforma= mostrarid_color_generalEstadoProforma;
	}

	public Boolean getActivarid_color_generalEstadoProforma() {
		return this.activarid_color_generalEstadoProforma;
	}

	public void setActivarid_color_generalEstadoProforma(Boolean activarid_color_generalEstadoProforma) {
		this.activarid_color_generalEstadoProforma= activarid_color_generalEstadoProforma;
	}

	public Boolean getCargarid_color_generalEstadoProforma() {
		return this.cargarid_color_generalEstadoProforma;
	}

	public void setCargarid_color_generalEstadoProforma(Boolean cargarid_color_generalEstadoProforma) {
		this.cargarid_color_generalEstadoProforma= cargarid_color_generalEstadoProforma;
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
		
		
		this.setMostraridEstadoProforma(esInicial);
		this.setMostrarid_empresaEstadoProforma(esInicial);
		this.setMostrarcodigoEstadoProforma(esInicial);
		this.setMostrarnombreEstadoProforma(esInicial);
		this.setMostrarid_color_generalEstadoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoProformaConstantesFunciones.ID)) {
				this.setMostraridEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDCOLORGENERAL)) {
				this.setMostrarid_color_generalEstadoProforma(esAsigna);
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
		
		
		this.setActivaridEstadoProforma(esInicial);
		this.setActivarid_empresaEstadoProforma(esInicial);
		this.setActivarcodigoEstadoProforma(esInicial);
		this.setActivarnombreEstadoProforma(esInicial);
		this.setActivarid_color_generalEstadoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoProformaConstantesFunciones.ID)) {
				this.setActivaridEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDCOLORGENERAL)) {
				this.setActivarid_color_generalEstadoProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoProforma(esInicial);
		this.setResaltarid_empresaEstadoProforma(esInicial);
		this.setResaltarcodigoEstadoProforma(esInicial);
		this.setResaltarnombreEstadoProforma(esInicial);
		this.setResaltarid_color_generalEstadoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoProformaConstantesFunciones.ID)) {
				this.setResaltaridEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoProformaConstantesFunciones.IDCOLORGENERAL)) {
				this.setResaltarid_color_generalEstadoProforma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdColorGeneralEstadoProforma=true;

	public Boolean getMostrarFK_IdColorGeneralEstadoProforma() {
		return this.mostrarFK_IdColorGeneralEstadoProforma;
	}

	public void setMostrarFK_IdColorGeneralEstadoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdColorGeneralEstadoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEstadoProforma=true;

	public Boolean getMostrarFK_IdEmpresaEstadoProforma() {
		return this.mostrarFK_IdEmpresaEstadoProforma;
	}

	public void setMostrarFK_IdEmpresaEstadoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEstadoProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdColorGeneralEstadoProforma=true;

	public Boolean getActivarFK_IdColorGeneralEstadoProforma() {
		return this.activarFK_IdColorGeneralEstadoProforma;
	}

	public void setActivarFK_IdColorGeneralEstadoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdColorGeneralEstadoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEstadoProforma=true;

	public Boolean getActivarFK_IdEmpresaEstadoProforma() {
		return this.activarFK_IdEmpresaEstadoProforma;
	}

	public void setActivarFK_IdEmpresaEstadoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEstadoProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdColorGeneralEstadoProforma=null;

	public Border getResaltarFK_IdColorGeneralEstadoProforma() {
		return this.resaltarFK_IdColorGeneralEstadoProforma;
	}

	public void setResaltarFK_IdColorGeneralEstadoProforma(Border borderResaltar) {
		this.resaltarFK_IdColorGeneralEstadoProforma= borderResaltar;
	}

	public void setResaltarFK_IdColorGeneralEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdColorGeneralEstadoProforma= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEstadoProforma=null;

	public Border getResaltarFK_IdEmpresaEstadoProforma() {
		return this.resaltarFK_IdEmpresaEstadoProforma;
	}

	public void setResaltarFK_IdEmpresaEstadoProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEstadoProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEstadoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoProformaBeanSwingJInternalFrame estadoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEstadoProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}