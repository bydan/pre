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


import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDevolucionEmpresaConstantesFunciones extends TipoDevolucionEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDevolucionEmpresa";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDevolucionEmpresa"+TipoDevolucionEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDevolucionEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDevolucionEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDevolucionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDevolucionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDevolucionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDevolucionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDevolucionEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDevolucionEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDevolucionEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDevolucionEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Devolucion Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Devolucion Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Devolucion Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDevolucionEmpresa";
	public static final String OBJECTNAME="tipodevolucionempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_devolucion_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodevolucionempresa from "+TipoDevolucionEmpresaConstantesFunciones.SPERSISTENCENAME+" tipodevolucionempresa";
	public static String QUERYSELECTNATIVE="select "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".esta_activo from "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDevolucionEmpresaConstantesFuncionesAdditional tipodevolucionempresaConstantesFuncionesAdditional=null;
	
	public TipoDevolucionEmpresaConstantesFuncionesAdditional getTipoDevolucionEmpresaConstantesFuncionesAdditional() {
		return this.tipodevolucionempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoDevolucionEmpresaConstantesFuncionesAdditional(TipoDevolucionEmpresaConstantesFuncionesAdditional tipodevolucionempresaConstantesFuncionesAdditional) {
		try {
			this.tipodevolucionempresaConstantesFuncionesAdditional=tipodevolucionempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESTAACTIVO= "esta_activo";
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
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoDevolucionEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDevolucionEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDevolucionEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoDevolucionEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDevolucionEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDevolucionEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=TipoDevolucionEmpresaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getesta_activoDescripcion(TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipodevolucionempresa.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipodevolucionempresa.getId(),tipodevolucionempresa.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getTipoDevolucionEmpresaDescripcion(TipoDevolucionEmpresa tipodevolucionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodevolucionempresa !=null/* && tipodevolucionempresa.getId()!=0*/) {
			sDescripcion=tipodevolucionempresa.getnombre();//tipodevolucionempresatipodevolucionempresa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDevolucionEmpresaDescripcionDetallado(TipoDevolucionEmpresa tipodevolucionempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipodevolucionempresa.getId().toString()+",";
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodevolucionempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodevolucionempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodevolucionempresa.getcodigo()+",";
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodevolucionempresa.getnombre()+",";
		sDescripcion+=TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=tipodevolucionempresa.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDevolucionEmpresaDescripcion(TipoDevolucionEmpresa tipodevolucionempresa,String sValor) throws Exception {			
		if(tipodevolucionempresa !=null) {
			tipodevolucionempresa.setnombre(sValor);;//tipodevolucionempresatipodevolucionempresa.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodevolucionempresa.setcodigo(tipodevolucionempresa.getcodigo().trim());
		tipodevolucionempresa.setnombre(tipodevolucionempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> tipodevolucionempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDevolucionEmpresa tipodevolucionempresa: tipodevolucionempresas) {
			tipodevolucionempresa.setcodigo(tipodevolucionempresa.getcodigo().trim());
			tipodevolucionempresa.setnombre(tipodevolucionempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodevolucionempresa.getConCambioAuxiliar()) {
			tipodevolucionempresa.setIsDeleted(tipodevolucionempresa.getIsDeletedAuxiliar());	
			tipodevolucionempresa.setIsNew(tipodevolucionempresa.getIsNewAuxiliar());	
			tipodevolucionempresa.setIsChanged(tipodevolucionempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodevolucionempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodevolucionempresa.setIsDeletedAuxiliar(false);	
			tipodevolucionempresa.setIsNewAuxiliar(false);	
			tipodevolucionempresa.setIsChangedAuxiliar(false);
			
			tipodevolucionempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> tipodevolucionempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDevolucionEmpresa tipodevolucionempresa : tipodevolucionempresas) {
			if(conAsignarBase && tipodevolucionempresa.getConCambioAuxiliar()) {
				tipodevolucionempresa.setIsDeleted(tipodevolucionempresa.getIsDeletedAuxiliar());	
				tipodevolucionempresa.setIsNew(tipodevolucionempresa.getIsNewAuxiliar());	
				tipodevolucionempresa.setIsChanged(tipodevolucionempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodevolucionempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodevolucionempresa.setIsDeletedAuxiliar(false);	
				tipodevolucionempresa.setIsNewAuxiliar(false);	
				tipodevolucionempresa.setIsChangedAuxiliar(false);
				
				tipodevolucionempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> tipodevolucionempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoDevolucionEmpresa tipodevolucionempresa: tipodevolucionempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresa tipodevolucionempresaAux) throws Exception  {
		TipoDevolucionEmpresaConstantesFunciones.InicializarValoresTipoDevolucionEmpresa(tipodevolucionempresaAux,true);
		
		for(TipoDevolucionEmpresa tipodevolucionempresa: tipodevolucionempresas) {
			if(tipodevolucionempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDevolucionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDevolucionEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoDevolucionEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDevolucionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDevolucionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresa tipodevolucionempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDevolucionEmpresa tipodevolucionempresaAux: tipodevolucionempresas) {
			if(tipodevolucionempresaAux!=null && tipodevolucionempresa!=null) {
				if((tipodevolucionempresaAux.getId()==null && tipodevolucionempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodevolucionempresaAux.getId()!=null && tipodevolucionempresa.getId()!=null){
					if(tipodevolucionempresaAux.getId().equals(tipodevolucionempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> tipodevolucionempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDevolucionEmpresa tipodevolucionempresa: tipodevolucionempresas) {			
			if(tipodevolucionempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDevolucionEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_ID, TipoDevolucionEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoDevolucionEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_CODIGO, TipoDevolucionEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_NOMBRE, TipoDevolucionEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionEmpresaConstantesFunciones.LABEL_ESTAACTIVO, TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDevolucionEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucionEmpresa() throws Exception  {
		return TipoDevolucionEmpresaConstantesFunciones.getTiposSeleccionarTipoDevolucionEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucionEmpresa(Boolean conFk) throws Exception  {
		return TipoDevolucionEmpresaConstantesFunciones.getTiposSeleccionarTipoDevolucionEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucionEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDevolucionEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDevolucionEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDevolucionEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionEmpresaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(TipoDevolucionEmpresaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDevolucionEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresaAux) throws Exception {
		
			tipodevolucionempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodevolucionempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> tipodevolucionempresasTemp) throws Exception {
		for(TipoDevolucionEmpresa tipodevolucionempresaAux:tipodevolucionempresasTemp) {
			
			tipodevolucionempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodevolucionempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDevolucionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDevolucionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDevolucionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDevolucionEmpresaConstantesFunciones.getClassesRelationshipsOfTipoDevolucionEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDevolucionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaNotaCredito.class));
				classes.add(new Classe(DetaNotaCreditoSoli.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCredito.class)) {
						classes.add(new Classe(DetaNotaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCreditoSoli.class)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDevolucionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDevolucionEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDevolucionEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDevolucionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
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
	public static void actualizarLista(TipoDevolucionEmpresa tipodevolucionempresa,List<TipoDevolucionEmpresa> tipodevolucionempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDevolucionEmpresa tipodevolucionempresaEncontrado=null;
			
			for(TipoDevolucionEmpresa tipodevolucionempresaLocal:tipodevolucionempresas) {
				if(tipodevolucionempresaLocal.getId().equals(tipodevolucionempresa.getId())) {
					tipodevolucionempresaEncontrado=tipodevolucionempresaLocal;
					
					tipodevolucionempresaLocal.setIsChanged(tipodevolucionempresa.getIsChanged());
					tipodevolucionempresaLocal.setIsNew(tipodevolucionempresa.getIsNew());
					tipodevolucionempresaLocal.setIsDeleted(tipodevolucionempresa.getIsDeleted());
					
					tipodevolucionempresaLocal.setGeneralEntityOriginal(tipodevolucionempresa.getGeneralEntityOriginal());
					
					tipodevolucionempresaLocal.setId(tipodevolucionempresa.getId());	
					tipodevolucionempresaLocal.setVersionRow(tipodevolucionempresa.getVersionRow());	
					tipodevolucionempresaLocal.setid_empresa(tipodevolucionempresa.getid_empresa());	
					tipodevolucionempresaLocal.setcodigo(tipodevolucionempresa.getcodigo());	
					tipodevolucionempresaLocal.setnombre(tipodevolucionempresa.getnombre());	
					tipodevolucionempresaLocal.setesta_activo(tipodevolucionempresa.getesta_activo());	
					
					
					tipodevolucionempresaLocal.setDetaNotaCreditoSolis(tipodevolucionempresa.getDetaNotaCreditoSolis());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodevolucionempresa.getIsDeleted()) {
				if(!existe) {
					tipodevolucionempresas.add(tipodevolucionempresa);
				}
			} else {
				if(tipodevolucionempresaEncontrado!=null && permiteQuitar)  {
					tipodevolucionempresas.remove(tipodevolucionempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDevolucionEmpresa tipodevolucionempresa,List<TipoDevolucionEmpresa> tipodevolucionempresas) throws Exception {
		try	{			
			for(TipoDevolucionEmpresa tipodevolucionempresaLocal:tipodevolucionempresas) {
				if(tipodevolucionempresaLocal.getId().equals(tipodevolucionempresa.getId())) {
					tipodevolucionempresaLocal.setIsSelected(tipodevolucionempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> tipodevolucionempresasAux) throws Exception {
		//this.tipodevolucionempresasAux=tipodevolucionempresasAux;
		
		for(TipoDevolucionEmpresa tipodevolucionempresaAux:tipodevolucionempresasAux) {
			if(tipodevolucionempresaAux.getIsChanged()) {
				tipodevolucionempresaAux.setIsChanged(false);
			}		
			
			if(tipodevolucionempresaAux.getIsNew()) {
				tipodevolucionempresaAux.setIsNew(false);
			}	
			
			if(tipodevolucionempresaAux.getIsDeleted()) {
				tipodevolucionempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresaAux) throws Exception {
		//this.tipodevolucionempresaAux=tipodevolucionempresaAux;
		
			if(tipodevolucionempresaAux.getIsChanged()) {
				tipodevolucionempresaAux.setIsChanged(false);
			}		
			
			if(tipodevolucionempresaAux.getIsNew()) {
				tipodevolucionempresaAux.setIsNew(false);
			}	
			
			if(tipodevolucionempresaAux.getIsDeleted()) {
				tipodevolucionempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDevolucionEmpresa tipodevolucionempresaAsignar,TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		tipodevolucionempresaAsignar.setId(tipodevolucionempresa.getId());	
		tipodevolucionempresaAsignar.setVersionRow(tipodevolucionempresa.getVersionRow());	
		tipodevolucionempresaAsignar.setid_empresa(tipodevolucionempresa.getid_empresa());
		tipodevolucionempresaAsignar.setempresa_descripcion(tipodevolucionempresa.getempresa_descripcion());	
		tipodevolucionempresaAsignar.setcodigo(tipodevolucionempresa.getcodigo());	
		tipodevolucionempresaAsignar.setnombre(tipodevolucionempresa.getnombre());	
		tipodevolucionempresaAsignar.setesta_activo(tipodevolucionempresa.getesta_activo());	
	}
	
	public static void inicializarTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		try {
				tipodevolucionempresa.setId(0L);	
					
				tipodevolucionempresa.setid_empresa(-1L);	
				tipodevolucionempresa.setcodigo("");	
				tipodevolucionempresa.setnombre("");	
				tipodevolucionempresa.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDevolucionEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionEmpresaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDevolucionEmpresa(String sTipo,Row row,Workbook workbook,TipoDevolucionEmpresa tipodevolucionempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodevolucionempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodevolucionempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodevolucionempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipodevolucionempresa.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDevolucionEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDevolucionEmpresa() {
		return this.sFinalQueryTipoDevolucionEmpresa;
	}
	
	public void setsFinalQueryTipoDevolucionEmpresa(String sFinalQueryTipoDevolucionEmpresa) {
		this.sFinalQueryTipoDevolucionEmpresa= sFinalQueryTipoDevolucionEmpresa;
	}
	
	public Border resaltarSeleccionarTipoDevolucionEmpresa=null;
	
	public Border setResaltarSeleccionarTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDevolucionEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDevolucionEmpresa() {
		return this.resaltarSeleccionarTipoDevolucionEmpresa;
	}
	
	public void setResaltarSeleccionarTipoDevolucionEmpresa(Border borderResaltarSeleccionarTipoDevolucionEmpresa) {
		this.resaltarSeleccionarTipoDevolucionEmpresa= borderResaltarSeleccionarTipoDevolucionEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDevolucionEmpresa=null;
	public Boolean mostraridTipoDevolucionEmpresa=true;
	public Boolean activaridTipoDevolucionEmpresa=true;

	public Border resaltarid_empresaTipoDevolucionEmpresa=null;
	public Boolean mostrarid_empresaTipoDevolucionEmpresa=true;
	public Boolean activarid_empresaTipoDevolucionEmpresa=true;
	public Boolean cargarid_empresaTipoDevolucionEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDevolucionEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDevolucionEmpresa=null;
	public Boolean mostrarcodigoTipoDevolucionEmpresa=true;
	public Boolean activarcodigoTipoDevolucionEmpresa=true;

	public Border resaltarnombreTipoDevolucionEmpresa=null;
	public Boolean mostrarnombreTipoDevolucionEmpresa=true;
	public Boolean activarnombreTipoDevolucionEmpresa=true;

	public Border resaltaresta_activoTipoDevolucionEmpresa=null;
	public Boolean mostraresta_activoTipoDevolucionEmpresa=true;
	public Boolean activaresta_activoTipoDevolucionEmpresa=true;

	
	

	public Border setResaltaridTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoDevolucionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDevolucionEmpresa() {
		return this.resaltaridTipoDevolucionEmpresa;
	}

	public void setResaltaridTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltaridTipoDevolucionEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoDevolucionEmpresa() {
		return this.mostraridTipoDevolucionEmpresa;
	}

	public void setMostraridTipoDevolucionEmpresa(Boolean mostraridTipoDevolucionEmpresa) {
		this.mostraridTipoDevolucionEmpresa= mostraridTipoDevolucionEmpresa;
	}

	public Boolean getActivaridTipoDevolucionEmpresa() {
		return this.activaridTipoDevolucionEmpresa;
	}

	public void setActivaridTipoDevolucionEmpresa(Boolean activaridTipoDevolucionEmpresa) {
		this.activaridTipoDevolucionEmpresa= activaridTipoDevolucionEmpresa;
	}

	public Border setResaltarid_empresaTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDevolucionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDevolucionEmpresa() {
		return this.resaltarid_empresaTipoDevolucionEmpresa;
	}

	public void setResaltarid_empresaTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoDevolucionEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDevolucionEmpresa() {
		return this.mostrarid_empresaTipoDevolucionEmpresa;
	}

	public void setMostrarid_empresaTipoDevolucionEmpresa(Boolean mostrarid_empresaTipoDevolucionEmpresa) {
		this.mostrarid_empresaTipoDevolucionEmpresa= mostrarid_empresaTipoDevolucionEmpresa;
	}

	public Boolean getActivarid_empresaTipoDevolucionEmpresa() {
		return this.activarid_empresaTipoDevolucionEmpresa;
	}

	public void setActivarid_empresaTipoDevolucionEmpresa(Boolean activarid_empresaTipoDevolucionEmpresa) {
		this.activarid_empresaTipoDevolucionEmpresa= activarid_empresaTipoDevolucionEmpresa;
	}

	public Boolean getCargarid_empresaTipoDevolucionEmpresa() {
		return this.cargarid_empresaTipoDevolucionEmpresa;
	}

	public void setCargarid_empresaTipoDevolucionEmpresa(Boolean cargarid_empresaTipoDevolucionEmpresa) {
		this.cargarid_empresaTipoDevolucionEmpresa= cargarid_empresaTipoDevolucionEmpresa;
	}

	public Border setResaltarcodigoTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDevolucionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDevolucionEmpresa() {
		return this.resaltarcodigoTipoDevolucionEmpresa;
	}

	public void setResaltarcodigoTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoDevolucionEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDevolucionEmpresa() {
		return this.mostrarcodigoTipoDevolucionEmpresa;
	}

	public void setMostrarcodigoTipoDevolucionEmpresa(Boolean mostrarcodigoTipoDevolucionEmpresa) {
		this.mostrarcodigoTipoDevolucionEmpresa= mostrarcodigoTipoDevolucionEmpresa;
	}

	public Boolean getActivarcodigoTipoDevolucionEmpresa() {
		return this.activarcodigoTipoDevolucionEmpresa;
	}

	public void setActivarcodigoTipoDevolucionEmpresa(Boolean activarcodigoTipoDevolucionEmpresa) {
		this.activarcodigoTipoDevolucionEmpresa= activarcodigoTipoDevolucionEmpresa;
	}

	public Border setResaltarnombreTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDevolucionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDevolucionEmpresa() {
		return this.resaltarnombreTipoDevolucionEmpresa;
	}

	public void setResaltarnombreTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoDevolucionEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDevolucionEmpresa() {
		return this.mostrarnombreTipoDevolucionEmpresa;
	}

	public void setMostrarnombreTipoDevolucionEmpresa(Boolean mostrarnombreTipoDevolucionEmpresa) {
		this.mostrarnombreTipoDevolucionEmpresa= mostrarnombreTipoDevolucionEmpresa;
	}

	public Boolean getActivarnombreTipoDevolucionEmpresa() {
		return this.activarnombreTipoDevolucionEmpresa;
	}

	public void setActivarnombreTipoDevolucionEmpresa(Boolean activarnombreTipoDevolucionEmpresa) {
		this.activarnombreTipoDevolucionEmpresa= activarnombreTipoDevolucionEmpresa;
	}

	public Border setResaltaresta_activoTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltar);
		
		this.resaltaresta_activoTipoDevolucionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoTipoDevolucionEmpresa() {
		return this.resaltaresta_activoTipoDevolucionEmpresa;
	}

	public void setResaltaresta_activoTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltaresta_activoTipoDevolucionEmpresa= borderResaltar;
	}

	public Boolean getMostraresta_activoTipoDevolucionEmpresa() {
		return this.mostraresta_activoTipoDevolucionEmpresa;
	}

	public void setMostraresta_activoTipoDevolucionEmpresa(Boolean mostraresta_activoTipoDevolucionEmpresa) {
		this.mostraresta_activoTipoDevolucionEmpresa= mostraresta_activoTipoDevolucionEmpresa;
	}

	public Boolean getActivaresta_activoTipoDevolucionEmpresa() {
		return this.activaresta_activoTipoDevolucionEmpresa;
	}

	public void setActivaresta_activoTipoDevolucionEmpresa(Boolean activaresta_activoTipoDevolucionEmpresa) {
		this.activaresta_activoTipoDevolucionEmpresa= activaresta_activoTipoDevolucionEmpresa;
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
		
		
		this.setMostraridTipoDevolucionEmpresa(esInicial);
		this.setMostrarid_empresaTipoDevolucionEmpresa(esInicial);
		this.setMostrarcodigoTipoDevolucionEmpresa(esInicial);
		this.setMostrarnombreTipoDevolucionEmpresa(esInicial);
		this.setMostraresta_activoTipoDevolucionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoTipoDevolucionEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoDevolucionEmpresa(esInicial);
		this.setActivarid_empresaTipoDevolucionEmpresa(esInicial);
		this.setActivarcodigoTipoDevolucionEmpresa(esInicial);
		this.setActivarnombreTipoDevolucionEmpresa(esInicial);
		this.setActivaresta_activoTipoDevolucionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoTipoDevolucionEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDevolucionEmpresa(esInicial);
		this.setResaltarid_empresaTipoDevolucionEmpresa(esInicial);
		this.setResaltarcodigoTipoDevolucionEmpresa(esInicial);
		this.setResaltarnombreTipoDevolucionEmpresa(esInicial);
		this.setResaltaresta_activoTipoDevolucionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDevolucionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoTipoDevolucionEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetaNotaCreditoSoliTipoDevolucionEmpresa=null;

	public Border getResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa() {
		return this.resaltarDetaNotaCreditoSoliTipoDevolucionEmpresa;
	}

	public void setResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa(Border borderResaltarDetaNotaCreditoSoli) {
		if(borderResaltarDetaNotaCreditoSoli!=null) {
			this.resaltarDetaNotaCreditoSoliTipoDevolucionEmpresa= borderResaltarDetaNotaCreditoSoli;
		}
	}

	public Border setResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodevolucionempresaBeanSwingJInternalFrame.jTtoolBarTipoDevolucionEmpresa.setBorder(borderResaltarDetaNotaCreditoSoli);
			
		this.resaltarDetaNotaCreditoSoliTipoDevolucionEmpresa= borderResaltarDetaNotaCreditoSoli;

		 return borderResaltarDetaNotaCreditoSoli;
	}



	public Boolean mostrarDetaNotaCreditoSoliTipoDevolucionEmpresa=true;

	public Boolean getMostrarDetaNotaCreditoSoliTipoDevolucionEmpresa() {
		return this.mostrarDetaNotaCreditoSoliTipoDevolucionEmpresa;
	}

	public void setMostrarDetaNotaCreditoSoliTipoDevolucionEmpresa(Boolean visibilidadResaltarDetaNotaCreditoSoli) {
		this.mostrarDetaNotaCreditoSoliTipoDevolucionEmpresa= visibilidadResaltarDetaNotaCreditoSoli;
	}



	public Boolean activarDetaNotaCreditoSoliTipoDevolucionEmpresa=true;

	public Boolean gethabilitarResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa() {
		return this.activarDetaNotaCreditoSoliTipoDevolucionEmpresa;
	}

	public void setActivarDetaNotaCreditoSoliTipoDevolucionEmpresa(Boolean habilitarResaltarDetaNotaCreditoSoli) {
		this.activarDetaNotaCreditoSoliTipoDevolucionEmpresa= habilitarResaltarDetaNotaCreditoSoli;
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

		this.setMostrarDetaNotaCreditoSoliTipoDevolucionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setMostrarDetaNotaCreditoSoliTipoDevolucionEmpresa(esAsigna);
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

		this.setActivarDetaNotaCreditoSoliTipoDevolucionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setActivarDetaNotaCreditoSoliTipoDevolucionEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setResaltarDetaNotaCreditoSoliTipoDevolucionEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDevolucionEmpresa=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDevolucionEmpresa() {
		return this.mostrarBusquedaPorCodigoTipoDevolucionEmpresa;
	}

	public void setMostrarBusquedaPorCodigoTipoDevolucionEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDevolucionEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDevolucionEmpresa=true;

	public Boolean getMostrarBusquedaPorNombreTipoDevolucionEmpresa() {
		return this.mostrarBusquedaPorNombreTipoDevolucionEmpresa;
	}

	public void setMostrarBusquedaPorNombreTipoDevolucionEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDevolucionEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoDevolucionEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoDevolucionEmpresa() {
		return this.mostrarFK_IdEmpresaTipoDevolucionEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoDevolucionEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDevolucionEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDevolucionEmpresa=true;

	public Boolean getActivarBusquedaPorCodigoTipoDevolucionEmpresa() {
		return this.activarBusquedaPorCodigoTipoDevolucionEmpresa;
	}

	public void setActivarBusquedaPorCodigoTipoDevolucionEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDevolucionEmpresa= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDevolucionEmpresa=true;

	public Boolean getActivarBusquedaPorNombreTipoDevolucionEmpresa() {
		return this.activarBusquedaPorNombreTipoDevolucionEmpresa;
	}

	public void setActivarBusquedaPorNombreTipoDevolucionEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDevolucionEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoDevolucionEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoDevolucionEmpresa() {
		return this.activarFK_IdEmpresaTipoDevolucionEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoDevolucionEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDevolucionEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDevolucionEmpresa=null;

	public Border getResaltarBusquedaPorCodigoTipoDevolucionEmpresa() {
		return this.resaltarBusquedaPorCodigoTipoDevolucionEmpresa;
	}

	public void setResaltarBusquedaPorCodigoTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDevolucionEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDevolucionEmpresa= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDevolucionEmpresa=null;

	public Border getResaltarBusquedaPorNombreTipoDevolucionEmpresa() {
		return this.resaltarBusquedaPorNombreTipoDevolucionEmpresa;
	}

	public void setResaltarBusquedaPorNombreTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDevolucionEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDevolucionEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoDevolucionEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoDevolucionEmpresa() {
		return this.resaltarFK_IdEmpresaTipoDevolucionEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoDevolucionEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDevolucionEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDevolucionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionEmpresaBeanSwingJInternalFrame tipodevolucionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDevolucionEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}