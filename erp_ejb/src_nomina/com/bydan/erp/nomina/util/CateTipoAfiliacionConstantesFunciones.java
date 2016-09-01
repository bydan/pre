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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.CateTipoAfiliacionConstantesFunciones;
import com.bydan.erp.nomina.util.CateTipoAfiliacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CateTipoAfiliacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CateTipoAfiliacionConstantesFunciones extends CateTipoAfiliacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CateTipoAfiliacion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CateTipoAfiliacion"+CateTipoAfiliacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CateTipoAfiliacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CateTipoAfiliacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CateTipoAfiliacionConstantesFunciones.SCHEMA+"_"+CateTipoAfiliacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CateTipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CateTipoAfiliacionConstantesFunciones.SCHEMA+"_"+CateTipoAfiliacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CateTipoAfiliacionConstantesFunciones.SCHEMA+"_"+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CateTipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CateTipoAfiliacionConstantesFunciones.SCHEMA+"_"+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CateTipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CateTipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CateTipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CateTipoAfiliacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CateTipoAfiliacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CateTipoAfiliacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CateTipoAfiliacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cate Tipo Afiliaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cate Tipo Afiliacion";
	public static final String SCLASSWEBTITULO_LOWER="Cate Tipo Afiliacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CateTipoAfiliacion";
	public static final String OBJECTNAME="catetipoafiliacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cate_tipo_afiliacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select catetipoafiliacion from "+CateTipoAfiliacionConstantesFunciones.SPERSISTENCENAME+" catetipoafiliacion";
	public static String QUERYSELECTNATIVE="select "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".id,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".codigo,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".nombre,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".es_defecto from "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+CateTipoAfiliacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CateTipoAfiliacionConstantesFuncionesAdditional catetipoafiliacionConstantesFuncionesAdditional=null;
	
	public CateTipoAfiliacionConstantesFuncionesAdditional getCateTipoAfiliacionConstantesFuncionesAdditional() {
		return this.catetipoafiliacionConstantesFuncionesAdditional;
	}
	
	public void setCateTipoAfiliacionConstantesFuncionesAdditional(CateTipoAfiliacionConstantesFuncionesAdditional catetipoafiliacionConstantesFuncionesAdditional) {
		try {
			this.catetipoafiliacionConstantesFuncionesAdditional=catetipoafiliacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCateTipoAfiliacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CateTipoAfiliacionConstantesFunciones.CODIGO)) {sLabelColumna=CateTipoAfiliacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CateTipoAfiliacionConstantesFunciones.NOMBRE)) {sLabelColumna=CateTipoAfiliacionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CateTipoAfiliacionConstantesFunciones.ESDEFECTO)) {sLabelColumna=CateTipoAfiliacionConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(CateTipoAfiliacion catetipoafiliacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!catetipoafiliacion.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(CateTipoAfiliacion catetipoafiliacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(catetipoafiliacion.getId(),catetipoafiliacion.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getCateTipoAfiliacionDescripcion(CateTipoAfiliacion catetipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(catetipoafiliacion !=null/* && catetipoafiliacion.getId()!=0*/) {
			sDescripcion=catetipoafiliacion.getcodigo();//catetipoafiliacioncatetipoafiliacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCateTipoAfiliacionDescripcionDetallado(CateTipoAfiliacion catetipoafiliacion) {
		String sDescripcion="";
			
		sDescripcion+=CateTipoAfiliacionConstantesFunciones.ID+"=";
		sDescripcion+=catetipoafiliacion.getId().toString()+",";
		sDescripcion+=CateTipoAfiliacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=catetipoafiliacion.getVersionRow().toString()+",";
		sDescripcion+=CateTipoAfiliacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=catetipoafiliacion.getcodigo()+",";
		sDescripcion+=CateTipoAfiliacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=catetipoafiliacion.getnombre()+",";
		sDescripcion+=CateTipoAfiliacionConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=catetipoafiliacion.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCateTipoAfiliacionDescripcion(CateTipoAfiliacion catetipoafiliacion,String sValor) throws Exception {			
		if(catetipoafiliacion !=null) {
			catetipoafiliacion.setcodigo(sValor);;//catetipoafiliacioncatetipoafiliacion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		catetipoafiliacion.setcodigo(catetipoafiliacion.getcodigo().trim());
		catetipoafiliacion.setnombre(catetipoafiliacion.getnombre().trim());
	}
	
	public static void quitarEspaciosCateTipoAfiliacions(List<CateTipoAfiliacion> catetipoafiliacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CateTipoAfiliacion catetipoafiliacion: catetipoafiliacions) {
			catetipoafiliacion.setcodigo(catetipoafiliacion.getcodigo().trim());
			catetipoafiliacion.setnombre(catetipoafiliacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && catetipoafiliacion.getConCambioAuxiliar()) {
			catetipoafiliacion.setIsDeleted(catetipoafiliacion.getIsDeletedAuxiliar());	
			catetipoafiliacion.setIsNew(catetipoafiliacion.getIsNewAuxiliar());	
			catetipoafiliacion.setIsChanged(catetipoafiliacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			catetipoafiliacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			catetipoafiliacion.setIsDeletedAuxiliar(false);	
			catetipoafiliacion.setIsNewAuxiliar(false);	
			catetipoafiliacion.setIsChangedAuxiliar(false);
			
			catetipoafiliacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCateTipoAfiliacions(List<CateTipoAfiliacion> catetipoafiliacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CateTipoAfiliacion catetipoafiliacion : catetipoafiliacions) {
			if(conAsignarBase && catetipoafiliacion.getConCambioAuxiliar()) {
				catetipoafiliacion.setIsDeleted(catetipoafiliacion.getIsDeletedAuxiliar());	
				catetipoafiliacion.setIsNew(catetipoafiliacion.getIsNewAuxiliar());	
				catetipoafiliacion.setIsChanged(catetipoafiliacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				catetipoafiliacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				catetipoafiliacion.setIsDeletedAuxiliar(false);	
				catetipoafiliacion.setIsNewAuxiliar(false);	
				catetipoafiliacion.setIsChangedAuxiliar(false);
				
				catetipoafiliacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCateTipoAfiliacions(List<CateTipoAfiliacion> catetipoafiliacions,Boolean conEnteros) throws Exception  {
		
		for(CateTipoAfiliacion catetipoafiliacion: catetipoafiliacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCateTipoAfiliacion(List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacion catetipoafiliacionAux) throws Exception  {
		CateTipoAfiliacionConstantesFunciones.InicializarValoresCateTipoAfiliacion(catetipoafiliacionAux,true);
		
		for(CateTipoAfiliacion catetipoafiliacion: catetipoafiliacions) {
			if(catetipoafiliacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCateTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CateTipoAfiliacionConstantesFunciones.getArrayColumnasGlobalesCateTipoAfiliacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCateTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCateTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CateTipoAfiliacion> catetipoafiliacions,CateTipoAfiliacion catetipoafiliacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CateTipoAfiliacion catetipoafiliacionAux: catetipoafiliacions) {
			if(catetipoafiliacionAux!=null && catetipoafiliacion!=null) {
				if((catetipoafiliacionAux.getId()==null && catetipoafiliacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(catetipoafiliacionAux.getId()!=null && catetipoafiliacion.getId()!=null){
					if(catetipoafiliacionAux.getId().equals(catetipoafiliacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCateTipoAfiliacion(List<CateTipoAfiliacion> catetipoafiliacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CateTipoAfiliacion catetipoafiliacion: catetipoafiliacions) {			
			if(catetipoafiliacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCateTipoAfiliacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CateTipoAfiliacionConstantesFunciones.LABEL_ID, CateTipoAfiliacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CateTipoAfiliacionConstantesFunciones.LABEL_VERSIONROW, CateTipoAfiliacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CateTipoAfiliacionConstantesFunciones.LABEL_CODIGO, CateTipoAfiliacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CateTipoAfiliacionConstantesFunciones.LABEL_NOMBRE, CateTipoAfiliacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CateTipoAfiliacionConstantesFunciones.LABEL_ESDEFECTO, CateTipoAfiliacionConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCateTipoAfiliacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CateTipoAfiliacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CateTipoAfiliacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CateTipoAfiliacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CateTipoAfiliacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CateTipoAfiliacionConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCateTipoAfiliacion() throws Exception  {
		return CateTipoAfiliacionConstantesFunciones.getTiposSeleccionarCateTipoAfiliacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCateTipoAfiliacion(Boolean conFk) throws Exception  {
		return CateTipoAfiliacionConstantesFunciones.getTiposSeleccionarCateTipoAfiliacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCateTipoAfiliacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CateTipoAfiliacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CateTipoAfiliacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CateTipoAfiliacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CateTipoAfiliacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CateTipoAfiliacionConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(CateTipoAfiliacionConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCateTipoAfiliacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesCateTipoAfiliacion(List<CateTipoAfiliacion> catetipoafiliacionsTemp) throws Exception {
		for(CateTipoAfiliacion catetipoafiliacionAux:catetipoafiliacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCateTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCateTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCateTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CateTipoAfiliacionConstantesFunciones.getClassesRelationshipsOfCateTipoAfiliacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCateTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoAfiliacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoAfiliacion.class)) {
						classes.add(new Classe(TipoAfiliacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCateTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CateTipoAfiliacionConstantesFunciones.getClassesRelationshipsFromStringsOfCateTipoAfiliacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCateTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
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
	public static void actualizarLista(CateTipoAfiliacion catetipoafiliacion,List<CateTipoAfiliacion> catetipoafiliacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CateTipoAfiliacion catetipoafiliacionEncontrado=null;
			
			for(CateTipoAfiliacion catetipoafiliacionLocal:catetipoafiliacions) {
				if(catetipoafiliacionLocal.getId().equals(catetipoafiliacion.getId())) {
					catetipoafiliacionEncontrado=catetipoafiliacionLocal;
					
					catetipoafiliacionLocal.setIsChanged(catetipoafiliacion.getIsChanged());
					catetipoafiliacionLocal.setIsNew(catetipoafiliacion.getIsNew());
					catetipoafiliacionLocal.setIsDeleted(catetipoafiliacion.getIsDeleted());
					
					catetipoafiliacionLocal.setGeneralEntityOriginal(catetipoafiliacion.getGeneralEntityOriginal());
					
					catetipoafiliacionLocal.setId(catetipoafiliacion.getId());	
					catetipoafiliacionLocal.setVersionRow(catetipoafiliacion.getVersionRow());	
					catetipoafiliacionLocal.setcodigo(catetipoafiliacion.getcodigo());	
					catetipoafiliacionLocal.setnombre(catetipoafiliacion.getnombre());	
					catetipoafiliacionLocal.setes_defecto(catetipoafiliacion.getes_defecto());	
					
					
					catetipoafiliacionLocal.setClientes(catetipoafiliacion.getClientes());
					catetipoafiliacionLocal.setTipoAfiliacions(catetipoafiliacion.getTipoAfiliacions());
					
					existe=true;
					break;
				}
			}
			
			if(!catetipoafiliacion.getIsDeleted()) {
				if(!existe) {
					catetipoafiliacions.add(catetipoafiliacion);
				}
			} else {
				if(catetipoafiliacionEncontrado!=null && permiteQuitar)  {
					catetipoafiliacions.remove(catetipoafiliacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CateTipoAfiliacion catetipoafiliacion,List<CateTipoAfiliacion> catetipoafiliacions) throws Exception {
		try	{			
			for(CateTipoAfiliacion catetipoafiliacionLocal:catetipoafiliacions) {
				if(catetipoafiliacionLocal.getId().equals(catetipoafiliacion.getId())) {
					catetipoafiliacionLocal.setIsSelected(catetipoafiliacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCateTipoAfiliacion(List<CateTipoAfiliacion> catetipoafiliacionsAux) throws Exception {
		//this.catetipoafiliacionsAux=catetipoafiliacionsAux;
		
		for(CateTipoAfiliacion catetipoafiliacionAux:catetipoafiliacionsAux) {
			if(catetipoafiliacionAux.getIsChanged()) {
				catetipoafiliacionAux.setIsChanged(false);
			}		
			
			if(catetipoafiliacionAux.getIsNew()) {
				catetipoafiliacionAux.setIsNew(false);
			}	
			
			if(catetipoafiliacionAux.getIsDeleted()) {
				catetipoafiliacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacionAux) throws Exception {
		//this.catetipoafiliacionAux=catetipoafiliacionAux;
		
			if(catetipoafiliacionAux.getIsChanged()) {
				catetipoafiliacionAux.setIsChanged(false);
			}		
			
			if(catetipoafiliacionAux.getIsNew()) {
				catetipoafiliacionAux.setIsNew(false);
			}	
			
			if(catetipoafiliacionAux.getIsDeleted()) {
				catetipoafiliacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CateTipoAfiliacion catetipoafiliacionAsignar,CateTipoAfiliacion catetipoafiliacion) throws Exception {
		catetipoafiliacionAsignar.setId(catetipoafiliacion.getId());	
		catetipoafiliacionAsignar.setVersionRow(catetipoafiliacion.getVersionRow());	
		catetipoafiliacionAsignar.setcodigo(catetipoafiliacion.getcodigo());	
		catetipoafiliacionAsignar.setnombre(catetipoafiliacion.getnombre());	
		catetipoafiliacionAsignar.setes_defecto(catetipoafiliacion.getes_defecto());	
	}
	
	public static void inicializarCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion) throws Exception {
		try {
				catetipoafiliacion.setId(0L);	
					
				catetipoafiliacion.setcodigo("");	
				catetipoafiliacion.setnombre("");	
				catetipoafiliacion.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCateTipoAfiliacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CateTipoAfiliacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CateTipoAfiliacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CateTipoAfiliacionConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCateTipoAfiliacion(String sTipo,Row row,Workbook workbook,CateTipoAfiliacion catetipoafiliacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(catetipoafiliacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(catetipoafiliacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(catetipoafiliacion.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCateTipoAfiliacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCateTipoAfiliacion() {
		return this.sFinalQueryCateTipoAfiliacion;
	}
	
	public void setsFinalQueryCateTipoAfiliacion(String sFinalQueryCateTipoAfiliacion) {
		this.sFinalQueryCateTipoAfiliacion= sFinalQueryCateTipoAfiliacion;
	}
	
	public Border resaltarSeleccionarCateTipoAfiliacion=null;
	
	public Border setResaltarSeleccionarCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCateTipoAfiliacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCateTipoAfiliacion() {
		return this.resaltarSeleccionarCateTipoAfiliacion;
	}
	
	public void setResaltarSeleccionarCateTipoAfiliacion(Border borderResaltarSeleccionarCateTipoAfiliacion) {
		this.resaltarSeleccionarCateTipoAfiliacion= borderResaltarSeleccionarCateTipoAfiliacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCateTipoAfiliacion=null;
	public Boolean mostraridCateTipoAfiliacion=true;
	public Boolean activaridCateTipoAfiliacion=true;

	public Border resaltarcodigoCateTipoAfiliacion=null;
	public Boolean mostrarcodigoCateTipoAfiliacion=true;
	public Boolean activarcodigoCateTipoAfiliacion=true;

	public Border resaltarnombreCateTipoAfiliacion=null;
	public Boolean mostrarnombreCateTipoAfiliacion=true;
	public Boolean activarnombreCateTipoAfiliacion=true;

	public Border resaltares_defectoCateTipoAfiliacion=null;
	public Boolean mostrares_defectoCateTipoAfiliacion=true;
	public Boolean activares_defectoCateTipoAfiliacion=true;

	
	

	public Border setResaltaridCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltaridCateTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCateTipoAfiliacion() {
		return this.resaltaridCateTipoAfiliacion;
	}

	public void setResaltaridCateTipoAfiliacion(Border borderResaltar) {
		this.resaltaridCateTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostraridCateTipoAfiliacion() {
		return this.mostraridCateTipoAfiliacion;
	}

	public void setMostraridCateTipoAfiliacion(Boolean mostraridCateTipoAfiliacion) {
		this.mostraridCateTipoAfiliacion= mostraridCateTipoAfiliacion;
	}

	public Boolean getActivaridCateTipoAfiliacion() {
		return this.activaridCateTipoAfiliacion;
	}

	public void setActivaridCateTipoAfiliacion(Boolean activaridCateTipoAfiliacion) {
		this.activaridCateTipoAfiliacion= activaridCateTipoAfiliacion;
	}

	public Border setResaltarcodigoCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarcodigoCateTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCateTipoAfiliacion() {
		return this.resaltarcodigoCateTipoAfiliacion;
	}

	public void setResaltarcodigoCateTipoAfiliacion(Border borderResaltar) {
		this.resaltarcodigoCateTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarcodigoCateTipoAfiliacion() {
		return this.mostrarcodigoCateTipoAfiliacion;
	}

	public void setMostrarcodigoCateTipoAfiliacion(Boolean mostrarcodigoCateTipoAfiliacion) {
		this.mostrarcodigoCateTipoAfiliacion= mostrarcodigoCateTipoAfiliacion;
	}

	public Boolean getActivarcodigoCateTipoAfiliacion() {
		return this.activarcodigoCateTipoAfiliacion;
	}

	public void setActivarcodigoCateTipoAfiliacion(Boolean activarcodigoCateTipoAfiliacion) {
		this.activarcodigoCateTipoAfiliacion= activarcodigoCateTipoAfiliacion;
	}

	public Border setResaltarnombreCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarnombreCateTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCateTipoAfiliacion() {
		return this.resaltarnombreCateTipoAfiliacion;
	}

	public void setResaltarnombreCateTipoAfiliacion(Border borderResaltar) {
		this.resaltarnombreCateTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarnombreCateTipoAfiliacion() {
		return this.mostrarnombreCateTipoAfiliacion;
	}

	public void setMostrarnombreCateTipoAfiliacion(Boolean mostrarnombreCateTipoAfiliacion) {
		this.mostrarnombreCateTipoAfiliacion= mostrarnombreCateTipoAfiliacion;
	}

	public Boolean getActivarnombreCateTipoAfiliacion() {
		return this.activarnombreCateTipoAfiliacion;
	}

	public void setActivarnombreCateTipoAfiliacion(Boolean activarnombreCateTipoAfiliacion) {
		this.activarnombreCateTipoAfiliacion= activarnombreCateTipoAfiliacion;
	}

	public Border setResaltares_defectoCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltares_defectoCateTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoCateTipoAfiliacion() {
		return this.resaltares_defectoCateTipoAfiliacion;
	}

	public void setResaltares_defectoCateTipoAfiliacion(Border borderResaltar) {
		this.resaltares_defectoCateTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrares_defectoCateTipoAfiliacion() {
		return this.mostrares_defectoCateTipoAfiliacion;
	}

	public void setMostrares_defectoCateTipoAfiliacion(Boolean mostrares_defectoCateTipoAfiliacion) {
		this.mostrares_defectoCateTipoAfiliacion= mostrares_defectoCateTipoAfiliacion;
	}

	public Boolean getActivares_defectoCateTipoAfiliacion() {
		return this.activares_defectoCateTipoAfiliacion;
	}

	public void setActivares_defectoCateTipoAfiliacion(Boolean activares_defectoCateTipoAfiliacion) {
		this.activares_defectoCateTipoAfiliacion= activares_defectoCateTipoAfiliacion;
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
		
		
		this.setMostraridCateTipoAfiliacion(esInicial);
		this.setMostrarcodigoCateTipoAfiliacion(esInicial);
		this.setMostrarnombreCateTipoAfiliacion(esInicial);
		this.setMostrares_defectoCateTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ID)) {
				this.setMostraridCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoCateTipoAfiliacion(esAsigna);
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
		
		
		this.setActivaridCateTipoAfiliacion(esInicial);
		this.setActivarcodigoCateTipoAfiliacion(esInicial);
		this.setActivarnombreCateTipoAfiliacion(esInicial);
		this.setActivares_defectoCateTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ID)) {
				this.setActivaridCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoCateTipoAfiliacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCateTipoAfiliacion(esInicial);
		this.setResaltarcodigoCateTipoAfiliacion(esInicial);
		this.setResaltarnombreCateTipoAfiliacion(esInicial);
		this.setResaltares_defectoCateTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ID)) {
				this.setResaltaridCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CateTipoAfiliacionConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoCateTipoAfiliacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteCateTipoAfiliacion=null;

	public Border getResaltarClienteCateTipoAfiliacion() {
		return this.resaltarClienteCateTipoAfiliacion;
	}

	public void setResaltarClienteCateTipoAfiliacion(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteCateTipoAfiliacion= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltarCliente);
			
		this.resaltarClienteCateTipoAfiliacion= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteCateTipoAfiliacion=true;

	public Boolean getMostrarClienteCateTipoAfiliacion() {
		return this.mostrarClienteCateTipoAfiliacion;
	}

	public void setMostrarClienteCateTipoAfiliacion(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteCateTipoAfiliacion= visibilidadResaltarCliente;
	}



	public Boolean activarClienteCateTipoAfiliacion=true;

	public Boolean gethabilitarResaltarClienteCateTipoAfiliacion() {
		return this.activarClienteCateTipoAfiliacion;
	}

	public void setActivarClienteCateTipoAfiliacion(Boolean habilitarResaltarCliente) {
		this.activarClienteCateTipoAfiliacion= habilitarResaltarCliente;
	}


	public Border resaltarTipoAfiliacionCateTipoAfiliacion=null;

	public Border getResaltarTipoAfiliacionCateTipoAfiliacion() {
		return this.resaltarTipoAfiliacionCateTipoAfiliacion;
	}

	public void setResaltarTipoAfiliacionCateTipoAfiliacion(Border borderResaltarTipoAfiliacion) {
		if(borderResaltarTipoAfiliacion!=null) {
			this.resaltarTipoAfiliacionCateTipoAfiliacion= borderResaltarTipoAfiliacion;
		}
	}

	public Border setResaltarTipoAfiliacionCateTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoAfiliacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//catetipoafiliacionBeanSwingJInternalFrame.jTtoolBarCateTipoAfiliacion.setBorder(borderResaltarTipoAfiliacion);
			
		this.resaltarTipoAfiliacionCateTipoAfiliacion= borderResaltarTipoAfiliacion;

		 return borderResaltarTipoAfiliacion;
	}



	public Boolean mostrarTipoAfiliacionCateTipoAfiliacion=true;

	public Boolean getMostrarTipoAfiliacionCateTipoAfiliacion() {
		return this.mostrarTipoAfiliacionCateTipoAfiliacion;
	}

	public void setMostrarTipoAfiliacionCateTipoAfiliacion(Boolean visibilidadResaltarTipoAfiliacion) {
		this.mostrarTipoAfiliacionCateTipoAfiliacion= visibilidadResaltarTipoAfiliacion;
	}



	public Boolean activarTipoAfiliacionCateTipoAfiliacion=true;

	public Boolean gethabilitarResaltarTipoAfiliacionCateTipoAfiliacion() {
		return this.activarTipoAfiliacionCateTipoAfiliacion;
	}

	public void setActivarTipoAfiliacionCateTipoAfiliacion(Boolean habilitarResaltarTipoAfiliacion) {
		this.activarTipoAfiliacionCateTipoAfiliacion= habilitarResaltarTipoAfiliacion;
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

		this.setMostrarClienteCateTipoAfiliacion(esInicial);
		this.setMostrarTipoAfiliacionCateTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoAfiliacion.class)) {
				this.setMostrarTipoAfiliacionCateTipoAfiliacion(esAsigna);
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

		this.setActivarClienteCateTipoAfiliacion(esInicial);
		this.setActivarTipoAfiliacionCateTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoAfiliacion.class)) {
				this.setActivarTipoAfiliacionCateTipoAfiliacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CateTipoAfiliacionBeanSwingJInternalFrame catetipoafiliacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteCateTipoAfiliacion(esInicial);
		this.setResaltarTipoAfiliacionCateTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteCateTipoAfiliacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoAfiliacion.class)) {
				this.setResaltarTipoAfiliacionCateTipoAfiliacion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}