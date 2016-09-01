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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ArancelConstantesFunciones;
import com.bydan.erp.inventario.util.ArancelParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ArancelParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ArancelConstantesFunciones extends ArancelConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Arancel";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Arancel"+ArancelConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ArancelHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ArancelHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ArancelConstantesFunciones.SCHEMA+"_"+ArancelConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ArancelHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ArancelConstantesFunciones.SCHEMA+"_"+ArancelConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ArancelConstantesFunciones.SCHEMA+"_"+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ArancelHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ArancelConstantesFunciones.SCHEMA+"_"+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ArancelHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ArancelHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ArancelConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ArancelConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ArancelConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ArancelConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ArancelConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Aranceles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Arancel";
	public static final String SCLASSWEBTITULO_LOWER="Arancel";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Arancel";
	public static final String OBJECTNAME="arancel";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="arancel";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select arancel from "+ArancelConstantesFunciones.SPERSISTENCENAME+" arancel";
	public static String QUERYSELECTNATIVE="select "+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".id,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".version_row,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".id_empresa,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".codigo,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".nombre,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".porcentaje,"+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME+".observacion from "+ArancelConstantesFunciones.SCHEMA+"."+ArancelConstantesFunciones.TABLENAME;//+" as "+ArancelConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ArancelConstantesFuncionesAdditional arancelConstantesFuncionesAdditional=null;
	
	public ArancelConstantesFuncionesAdditional getArancelConstantesFuncionesAdditional() {
		return this.arancelConstantesFuncionesAdditional;
	}
	
	public void setArancelConstantesFuncionesAdditional(ArancelConstantesFuncionesAdditional arancelConstantesFuncionesAdditional) {
		try {
			this.arancelConstantesFuncionesAdditional=arancelConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJE= "porcentaje";
    public static final String OBSERVACION= "observacion";
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
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getArancelLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ArancelConstantesFunciones.IDEMPRESA)) {sLabelColumna=ArancelConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ArancelConstantesFunciones.CODIGO)) {sLabelColumna=ArancelConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ArancelConstantesFunciones.NOMBRE)) {sLabelColumna=ArancelConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ArancelConstantesFunciones.PORCENTAJE)) {sLabelColumna=ArancelConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ArancelConstantesFunciones.OBSERVACION)) {sLabelColumna=ArancelConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getArancelDescripcion(Arancel arancel) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(arancel !=null/* && arancel.getId()!=0*/) {
			sDescripcion=arancel.getcodigo();//arancelarancel.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getArancelDescripcionDetallado(Arancel arancel) {
		String sDescripcion="";
			
		sDescripcion+=ArancelConstantesFunciones.ID+"=";
		sDescripcion+=arancel.getId().toString()+",";
		sDescripcion+=ArancelConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=arancel.getVersionRow().toString()+",";
		sDescripcion+=ArancelConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=arancel.getid_empresa().toString()+",";
		sDescripcion+=ArancelConstantesFunciones.CODIGO+"=";
		sDescripcion+=arancel.getcodigo()+",";
		sDescripcion+=ArancelConstantesFunciones.NOMBRE+"=";
		sDescripcion+=arancel.getnombre()+",";
		sDescripcion+=ArancelConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=arancel.getporcentaje().toString()+",";
		sDescripcion+=ArancelConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=arancel.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setArancelDescripcion(Arancel arancel,String sValor) throws Exception {			
		if(arancel !=null) {
			arancel.setcodigo(sValor);;//arancelarancel.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosArancel(Arancel arancel,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		arancel.setcodigo(arancel.getcodigo().trim());
		arancel.setnombre(arancel.getnombre().trim());
		arancel.setobservacion(arancel.getobservacion().trim());
	}
	
	public static void quitarEspaciosArancels(List<Arancel> arancels,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Arancel arancel: arancels) {
			arancel.setcodigo(arancel.getcodigo().trim());
			arancel.setnombre(arancel.getnombre().trim());
			arancel.setobservacion(arancel.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresArancel(Arancel arancel,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && arancel.getConCambioAuxiliar()) {
			arancel.setIsDeleted(arancel.getIsDeletedAuxiliar());	
			arancel.setIsNew(arancel.getIsNewAuxiliar());	
			arancel.setIsChanged(arancel.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			arancel.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			arancel.setIsDeletedAuxiliar(false);	
			arancel.setIsNewAuxiliar(false);	
			arancel.setIsChangedAuxiliar(false);
			
			arancel.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresArancels(List<Arancel> arancels,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Arancel arancel : arancels) {
			if(conAsignarBase && arancel.getConCambioAuxiliar()) {
				arancel.setIsDeleted(arancel.getIsDeletedAuxiliar());	
				arancel.setIsNew(arancel.getIsNewAuxiliar());	
				arancel.setIsChanged(arancel.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				arancel.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				arancel.setIsDeletedAuxiliar(false);	
				arancel.setIsNewAuxiliar(false);	
				arancel.setIsChangedAuxiliar(false);
				
				arancel.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresArancel(Arancel arancel,Boolean conEnteros) throws Exception  {
		arancel.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresArancels(List<Arancel> arancels,Boolean conEnteros) throws Exception  {
		
		for(Arancel arancel: arancels) {
			arancel.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaArancel(List<Arancel> arancels,Arancel arancelAux) throws Exception  {
		ArancelConstantesFunciones.InicializarValoresArancel(arancelAux,true);
		
		for(Arancel arancel: arancels) {
			if(arancel.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			arancelAux.setporcentaje(arancelAux.getporcentaje()+arancel.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesArancel(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ArancelConstantesFunciones.getArrayColumnasGlobalesArancel(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesArancel(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ArancelConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ArancelConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoArancel(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Arancel> arancels,Arancel arancel,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Arancel arancelAux: arancels) {
			if(arancelAux!=null && arancel!=null) {
				if((arancelAux.getId()==null && arancel.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(arancelAux.getId()!=null && arancel.getId()!=null){
					if(arancelAux.getId().equals(arancel.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaArancel(List<Arancel> arancels) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(Arancel arancel: arancels) {			
			if(arancel.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=arancel.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ArancelConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ArancelConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaArancel() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_ID, ArancelConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_VERSIONROW, ArancelConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_IDEMPRESA, ArancelConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_CODIGO, ArancelConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_NOMBRE, ArancelConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_PORCENTAJE, ArancelConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ArancelConstantesFunciones.LABEL_OBSERVACION, ArancelConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasArancel() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ArancelConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArancel() throws Exception  {
		return ArancelConstantesFunciones.getTiposSeleccionarArancel(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArancel(Boolean conFk) throws Exception  {
		return ArancelConstantesFunciones.getTiposSeleccionarArancel(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArancel(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ArancelConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ArancelConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ArancelConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ArancelConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ArancelConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ArancelConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ArancelConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ArancelConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ArancelConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(ArancelConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesArancel(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesArancel(Arancel arancelAux) throws Exception {
		
			arancelAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(arancelAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesArancel(List<Arancel> arancelsTemp) throws Exception {
		for(Arancel arancelAux:arancelsTemp) {
			
			arancelAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(arancelAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfArancel(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfArancel(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfArancel(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ArancelConstantesFunciones.getClassesRelationshipsOfArancel(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfArancel(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(DetallePedidoCompraImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoCompraImpor.class)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfArancel(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ArancelConstantesFunciones.getClassesRelationshipsFromStringsOfArancel(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfArancel(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(DetallePedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(DetallePedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompraImpor.class)); continue;
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
	public static void actualizarLista(Arancel arancel,List<Arancel> arancels,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Arancel arancelEncontrado=null;
			
			for(Arancel arancelLocal:arancels) {
				if(arancelLocal.getId().equals(arancel.getId())) {
					arancelEncontrado=arancelLocal;
					
					arancelLocal.setIsChanged(arancel.getIsChanged());
					arancelLocal.setIsNew(arancel.getIsNew());
					arancelLocal.setIsDeleted(arancel.getIsDeleted());
					
					arancelLocal.setGeneralEntityOriginal(arancel.getGeneralEntityOriginal());
					
					arancelLocal.setId(arancel.getId());	
					arancelLocal.setVersionRow(arancel.getVersionRow());	
					arancelLocal.setid_empresa(arancel.getid_empresa());	
					arancelLocal.setcodigo(arancel.getcodigo());	
					arancelLocal.setnombre(arancel.getnombre());	
					arancelLocal.setporcentaje(arancel.getporcentaje());	
					arancelLocal.setobservacion(arancel.getobservacion());	
					
					
					arancelLocal.setProductos(arancel.getProductos());
					arancelLocal.setDetallePedidoCompraImpors(arancel.getDetallePedidoCompraImpors());
					
					existe=true;
					break;
				}
			}
			
			if(!arancel.getIsDeleted()) {
				if(!existe) {
					arancels.add(arancel);
				}
			} else {
				if(arancelEncontrado!=null && permiteQuitar)  {
					arancels.remove(arancelEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Arancel arancel,List<Arancel> arancels) throws Exception {
		try	{			
			for(Arancel arancelLocal:arancels) {
				if(arancelLocal.getId().equals(arancel.getId())) {
					arancelLocal.setIsSelected(arancel.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesArancel(List<Arancel> arancelsAux) throws Exception {
		//this.arancelsAux=arancelsAux;
		
		for(Arancel arancelAux:arancelsAux) {
			if(arancelAux.getIsChanged()) {
				arancelAux.setIsChanged(false);
			}		
			
			if(arancelAux.getIsNew()) {
				arancelAux.setIsNew(false);
			}	
			
			if(arancelAux.getIsDeleted()) {
				arancelAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesArancel(Arancel arancelAux) throws Exception {
		//this.arancelAux=arancelAux;
		
			if(arancelAux.getIsChanged()) {
				arancelAux.setIsChanged(false);
			}		
			
			if(arancelAux.getIsNew()) {
				arancelAux.setIsNew(false);
			}	
			
			if(arancelAux.getIsDeleted()) {
				arancelAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Arancel arancelAsignar,Arancel arancel) throws Exception {
		arancelAsignar.setId(arancel.getId());	
		arancelAsignar.setVersionRow(arancel.getVersionRow());	
		arancelAsignar.setid_empresa(arancel.getid_empresa());
		arancelAsignar.setempresa_descripcion(arancel.getempresa_descripcion());	
		arancelAsignar.setcodigo(arancel.getcodigo());	
		arancelAsignar.setnombre(arancel.getnombre());	
		arancelAsignar.setporcentaje(arancel.getporcentaje());	
		arancelAsignar.setobservacion(arancel.getobservacion());	
	}
	
	public static void inicializarArancel(Arancel arancel) throws Exception {
		try {
				arancel.setId(0L);	
					
				arancel.setid_empresa(-1L);	
				arancel.setcodigo("");	
				arancel.setnombre("");	
				arancel.setporcentaje(0.0);	
				arancel.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderArancel(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ArancelConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ArancelConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ArancelConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ArancelConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ArancelConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataArancel(String sTipo,Row row,Workbook workbook,Arancel arancel,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(arancel.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(arancel.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(arancel.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(arancel.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(arancel.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryArancel=Constantes.SFINALQUERY;
	
	public String getsFinalQueryArancel() {
		return this.sFinalQueryArancel;
	}
	
	public void setsFinalQueryArancel(String sFinalQueryArancel) {
		this.sFinalQueryArancel= sFinalQueryArancel;
	}
	
	public Border resaltarSeleccionarArancel=null;
	
	public Border setResaltarSeleccionarArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarSeleccionarArancel= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarArancel() {
		return this.resaltarSeleccionarArancel;
	}
	
	public void setResaltarSeleccionarArancel(Border borderResaltarSeleccionarArancel) {
		this.resaltarSeleccionarArancel= borderResaltarSeleccionarArancel;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridArancel=null;
	public Boolean mostraridArancel=true;
	public Boolean activaridArancel=true;

	public Border resaltarid_empresaArancel=null;
	public Boolean mostrarid_empresaArancel=true;
	public Boolean activarid_empresaArancel=true;
	public Boolean cargarid_empresaArancel=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaArancel=false;//ConEventDepend=true

	public Border resaltarcodigoArancel=null;
	public Boolean mostrarcodigoArancel=true;
	public Boolean activarcodigoArancel=true;

	public Border resaltarnombreArancel=null;
	public Boolean mostrarnombreArancel=true;
	public Boolean activarnombreArancel=true;

	public Border resaltarporcentajeArancel=null;
	public Boolean mostrarporcentajeArancel=true;
	public Boolean activarporcentajeArancel=true;

	public Border resaltarobservacionArancel=null;
	public Boolean mostrarobservacionArancel=true;
	public Boolean activarobservacionArancel=true;

	
	

	public Border setResaltaridArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltaridArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridArancel() {
		return this.resaltaridArancel;
	}

	public void setResaltaridArancel(Border borderResaltar) {
		this.resaltaridArancel= borderResaltar;
	}

	public Boolean getMostraridArancel() {
		return this.mostraridArancel;
	}

	public void setMostraridArancel(Boolean mostraridArancel) {
		this.mostraridArancel= mostraridArancel;
	}

	public Boolean getActivaridArancel() {
		return this.activaridArancel;
	}

	public void setActivaridArancel(Boolean activaridArancel) {
		this.activaridArancel= activaridArancel;
	}

	public Border setResaltarid_empresaArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarid_empresaArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaArancel() {
		return this.resaltarid_empresaArancel;
	}

	public void setResaltarid_empresaArancel(Border borderResaltar) {
		this.resaltarid_empresaArancel= borderResaltar;
	}

	public Boolean getMostrarid_empresaArancel() {
		return this.mostrarid_empresaArancel;
	}

	public void setMostrarid_empresaArancel(Boolean mostrarid_empresaArancel) {
		this.mostrarid_empresaArancel= mostrarid_empresaArancel;
	}

	public Boolean getActivarid_empresaArancel() {
		return this.activarid_empresaArancel;
	}

	public void setActivarid_empresaArancel(Boolean activarid_empresaArancel) {
		this.activarid_empresaArancel= activarid_empresaArancel;
	}

	public Boolean getCargarid_empresaArancel() {
		return this.cargarid_empresaArancel;
	}

	public void setCargarid_empresaArancel(Boolean cargarid_empresaArancel) {
		this.cargarid_empresaArancel= cargarid_empresaArancel;
	}

	public Border setResaltarcodigoArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarcodigoArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoArancel() {
		return this.resaltarcodigoArancel;
	}

	public void setResaltarcodigoArancel(Border borderResaltar) {
		this.resaltarcodigoArancel= borderResaltar;
	}

	public Boolean getMostrarcodigoArancel() {
		return this.mostrarcodigoArancel;
	}

	public void setMostrarcodigoArancel(Boolean mostrarcodigoArancel) {
		this.mostrarcodigoArancel= mostrarcodigoArancel;
	}

	public Boolean getActivarcodigoArancel() {
		return this.activarcodigoArancel;
	}

	public void setActivarcodigoArancel(Boolean activarcodigoArancel) {
		this.activarcodigoArancel= activarcodigoArancel;
	}

	public Border setResaltarnombreArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarnombreArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreArancel() {
		return this.resaltarnombreArancel;
	}

	public void setResaltarnombreArancel(Border borderResaltar) {
		this.resaltarnombreArancel= borderResaltar;
	}

	public Boolean getMostrarnombreArancel() {
		return this.mostrarnombreArancel;
	}

	public void setMostrarnombreArancel(Boolean mostrarnombreArancel) {
		this.mostrarnombreArancel= mostrarnombreArancel;
	}

	public Boolean getActivarnombreArancel() {
		return this.activarnombreArancel;
	}

	public void setActivarnombreArancel(Boolean activarnombreArancel) {
		this.activarnombreArancel= activarnombreArancel;
	}

	public Border setResaltarporcentajeArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarporcentajeArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeArancel() {
		return this.resaltarporcentajeArancel;
	}

	public void setResaltarporcentajeArancel(Border borderResaltar) {
		this.resaltarporcentajeArancel= borderResaltar;
	}

	public Boolean getMostrarporcentajeArancel() {
		return this.mostrarporcentajeArancel;
	}

	public void setMostrarporcentajeArancel(Boolean mostrarporcentajeArancel) {
		this.mostrarporcentajeArancel= mostrarporcentajeArancel;
	}

	public Boolean getActivarporcentajeArancel() {
		return this.activarporcentajeArancel;
	}

	public void setActivarporcentajeArancel(Boolean activarporcentajeArancel) {
		this.activarporcentajeArancel= activarporcentajeArancel;
	}

	public Border setResaltarobservacionArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltar);
		
		this.resaltarobservacionArancel= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionArancel() {
		return this.resaltarobservacionArancel;
	}

	public void setResaltarobservacionArancel(Border borderResaltar) {
		this.resaltarobservacionArancel= borderResaltar;
	}

	public Boolean getMostrarobservacionArancel() {
		return this.mostrarobservacionArancel;
	}

	public void setMostrarobservacionArancel(Boolean mostrarobservacionArancel) {
		this.mostrarobservacionArancel= mostrarobservacionArancel;
	}

	public Boolean getActivarobservacionArancel() {
		return this.activarobservacionArancel;
	}

	public void setActivarobservacionArancel(Boolean activarobservacionArancel) {
		this.activarobservacionArancel= activarobservacionArancel;
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
		
		
		this.setMostraridArancel(esInicial);
		this.setMostrarid_empresaArancel(esInicial);
		this.setMostrarcodigoArancel(esInicial);
		this.setMostrarnombreArancel(esInicial);
		this.setMostrarporcentajeArancel(esInicial);
		this.setMostrarobservacionArancel(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ArancelConstantesFunciones.ID)) {
				this.setMostraridArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionArancel(esAsigna);
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
		
		
		this.setActivaridArancel(esInicial);
		this.setActivarid_empresaArancel(esInicial);
		this.setActivarcodigoArancel(esInicial);
		this.setActivarnombreArancel(esInicial);
		this.setActivarporcentajeArancel(esInicial);
		this.setActivarobservacionArancel(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ArancelConstantesFunciones.ID)) {
				this.setActivaridArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.CODIGO)) {
				this.setActivarcodigoArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.NOMBRE)) {
				this.setActivarnombreArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionArancel(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridArancel(esInicial);
		this.setResaltarid_empresaArancel(esInicial);
		this.setResaltarcodigoArancel(esInicial);
		this.setResaltarnombreArancel(esInicial);
		this.setResaltarporcentajeArancel(esInicial);
		this.setResaltarobservacionArancel(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ArancelConstantesFunciones.ID)) {
				this.setResaltaridArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeArancel(esAsigna);
				continue;
			}

			if(campo.clase.equals(ArancelConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionArancel(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoArancel=null;

	public Border getResaltarProductoArancel() {
		return this.resaltarProductoArancel;
	}

	public void setResaltarProductoArancel(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoArancel= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltarProducto);
			
		this.resaltarProductoArancel= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoArancel=true;

	public Boolean getMostrarProductoArancel() {
		return this.mostrarProductoArancel;
	}

	public void setMostrarProductoArancel(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoArancel= visibilidadResaltarProducto;
	}



	public Boolean activarProductoArancel=true;

	public Boolean gethabilitarResaltarProductoArancel() {
		return this.activarProductoArancel;
	}

	public void setActivarProductoArancel(Boolean habilitarResaltarProducto) {
		this.activarProductoArancel= habilitarResaltarProducto;
	}


	public Border resaltarDetallePedidoCompraImporArancel=null;

	public Border getResaltarDetallePedidoCompraImporArancel() {
		return this.resaltarDetallePedidoCompraImporArancel;
	}

	public void setResaltarDetallePedidoCompraImporArancel(Border borderResaltarDetallePedidoCompraImpor) {
		if(borderResaltarDetallePedidoCompraImpor!=null) {
			this.resaltarDetallePedidoCompraImporArancel= borderResaltarDetallePedidoCompraImpor;
		}
	}

	public Border setResaltarDetallePedidoCompraImporArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoCompraImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//arancelBeanSwingJInternalFrame.jTtoolBarArancel.setBorder(borderResaltarDetallePedidoCompraImpor);
			
		this.resaltarDetallePedidoCompraImporArancel= borderResaltarDetallePedidoCompraImpor;

		 return borderResaltarDetallePedidoCompraImpor;
	}



	public Boolean mostrarDetallePedidoCompraImporArancel=true;

	public Boolean getMostrarDetallePedidoCompraImporArancel() {
		return this.mostrarDetallePedidoCompraImporArancel;
	}

	public void setMostrarDetallePedidoCompraImporArancel(Boolean visibilidadResaltarDetallePedidoCompraImpor) {
		this.mostrarDetallePedidoCompraImporArancel= visibilidadResaltarDetallePedidoCompraImpor;
	}



	public Boolean activarDetallePedidoCompraImporArancel=true;

	public Boolean gethabilitarResaltarDetallePedidoCompraImporArancel() {
		return this.activarDetallePedidoCompraImporArancel;
	}

	public void setActivarDetallePedidoCompraImporArancel(Boolean habilitarResaltarDetallePedidoCompraImpor) {
		this.activarDetallePedidoCompraImporArancel= habilitarResaltarDetallePedidoCompraImpor;
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

		this.setMostrarProductoArancel(esInicial);
		this.setMostrarDetallePedidoCompraImporArancel(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoArancel(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setMostrarDetallePedidoCompraImporArancel(esAsigna);
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

		this.setActivarProductoArancel(esInicial);
		this.setActivarDetallePedidoCompraImporArancel(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoArancel(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setActivarDetallePedidoCompraImporArancel(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoArancel(esInicial);
		this.setResaltarDetallePedidoCompraImporArancel(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoArancel(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePedidoCompraImpor.class)) {
				this.setResaltarDetallePedidoCompraImporArancel(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoArancel=true;

	public Boolean getMostrarBusquedaPorCodigoArancel() {
		return this.mostrarBusquedaPorCodigoArancel;
	}

	public void setMostrarBusquedaPorCodigoArancel(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoArancel= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreArancel=true;

	public Boolean getMostrarBusquedaPorNombreArancel() {
		return this.mostrarBusquedaPorNombreArancel;
	}

	public void setMostrarBusquedaPorNombreArancel(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreArancel= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaArancel=true;

	public Boolean getMostrarFK_IdEmpresaArancel() {
		return this.mostrarFK_IdEmpresaArancel;
	}

	public void setMostrarFK_IdEmpresaArancel(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaArancel= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoArancel=true;

	public Boolean getActivarBusquedaPorCodigoArancel() {
		return this.activarBusquedaPorCodigoArancel;
	}

	public void setActivarBusquedaPorCodigoArancel(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoArancel= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreArancel=true;

	public Boolean getActivarBusquedaPorNombreArancel() {
		return this.activarBusquedaPorNombreArancel;
	}

	public void setActivarBusquedaPorNombreArancel(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreArancel= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaArancel=true;

	public Boolean getActivarFK_IdEmpresaArancel() {
		return this.activarFK_IdEmpresaArancel;
	}

	public void setActivarFK_IdEmpresaArancel(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaArancel= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoArancel=null;

	public Border getResaltarBusquedaPorCodigoArancel() {
		return this.resaltarBusquedaPorCodigoArancel;
	}

	public void setResaltarBusquedaPorCodigoArancel(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoArancel= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoArancel= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreArancel=null;

	public Border getResaltarBusquedaPorNombreArancel() {
		return this.resaltarBusquedaPorNombreArancel;
	}

	public void setResaltarBusquedaPorNombreArancel(Border borderResaltar) {
		this.resaltarBusquedaPorNombreArancel= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreArancel= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaArancel=null;

	public Border getResaltarFK_IdEmpresaArancel() {
		return this.resaltarFK_IdEmpresaArancel;
	}

	public void setResaltarFK_IdEmpresaArancel(Border borderResaltar) {
		this.resaltarFK_IdEmpresaArancel= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaArancel(ParametroGeneralUsuario parametroGeneralUsuario/*ArancelBeanSwingJInternalFrame arancelBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaArancel= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}