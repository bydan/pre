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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoActivoFijoEmpresaConstantesFunciones extends TipoActivoFijoEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoActivoFijoEmpresa";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoActivoFijoEmpresa"+TipoActivoFijoEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoActivoFijoEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoActivoFijoEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"_"+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"_"+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"_"+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"_"+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoActivoFijoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoActivoFijoEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoActivoFijoEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoActivoFijoEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Activo Fijo Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Activo Fijo Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Activo Fijo Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoActivoFijoEmpresa";
	public static final String OBJECTNAME="tipoactivofijoempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_activo_fijo_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoactivofijoempresa from "+TipoActivoFijoEmpresaConstantesFunciones.SPERSISTENCENAME+" tipoactivofijoempresa";
	public static String QUERYSELECTNATIVE="select "+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME+".id,"+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoActivoFijoEmpresaConstantesFunciones.SCHEMA+"."+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoActivoFijoEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoActivoFijoEmpresaConstantesFuncionesAdditional tipoactivofijoempresaConstantesFuncionesAdditional=null;
	
	public TipoActivoFijoEmpresaConstantesFuncionesAdditional getTipoActivoFijoEmpresaConstantesFuncionesAdditional() {
		return this.tipoactivofijoempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoActivoFijoEmpresaConstantesFuncionesAdditional(TipoActivoFijoEmpresaConstantesFuncionesAdditional tipoactivofijoempresaConstantesFuncionesAdditional) {
		try {
			this.tipoactivofijoempresaConstantesFuncionesAdditional=tipoactivofijoempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoActivoFijoEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoActivoFijoEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoActivoFijoEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoActivoFijoEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoActivoFijoEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoActivoFijoEmpresaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoActivoFijoEmpresaDescripcion(TipoActivoFijoEmpresa tipoactivofijoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoactivofijoempresa !=null/* && tipoactivofijoempresa.getId()!=0*/) {
			sDescripcion=tipoactivofijoempresa.getcodigo();//tipoactivofijoempresatipoactivofijoempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoActivoFijoEmpresaDescripcionDetallado(TipoActivoFijoEmpresa tipoactivofijoempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoActivoFijoEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipoactivofijoempresa.getId().toString()+",";
		sDescripcion+=TipoActivoFijoEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoactivofijoempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoactivofijoempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoActivoFijoEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoactivofijoempresa.getcodigo()+",";
		sDescripcion+=TipoActivoFijoEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoactivofijoempresa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoActivoFijoEmpresaDescripcion(TipoActivoFijoEmpresa tipoactivofijoempresa,String sValor) throws Exception {			
		if(tipoactivofijoempresa !=null) {
			tipoactivofijoempresa.setcodigo(sValor);;//tipoactivofijoempresatipoactivofijoempresa.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoactivofijoempresa.setcodigo(tipoactivofijoempresa.getcodigo().trim());
		tipoactivofijoempresa.setnombre(tipoactivofijoempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoActivoFijoEmpresas(List<TipoActivoFijoEmpresa> tipoactivofijoempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa: tipoactivofijoempresas) {
			tipoactivofijoempresa.setcodigo(tipoactivofijoempresa.getcodigo().trim());
			tipoactivofijoempresa.setnombre(tipoactivofijoempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoactivofijoempresa.getConCambioAuxiliar()) {
			tipoactivofijoempresa.setIsDeleted(tipoactivofijoempresa.getIsDeletedAuxiliar());	
			tipoactivofijoempresa.setIsNew(tipoactivofijoempresa.getIsNewAuxiliar());	
			tipoactivofijoempresa.setIsChanged(tipoactivofijoempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoactivofijoempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoactivofijoempresa.setIsDeletedAuxiliar(false);	
			tipoactivofijoempresa.setIsNewAuxiliar(false);	
			tipoactivofijoempresa.setIsChangedAuxiliar(false);
			
			tipoactivofijoempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoActivoFijoEmpresas(List<TipoActivoFijoEmpresa> tipoactivofijoempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa : tipoactivofijoempresas) {
			if(conAsignarBase && tipoactivofijoempresa.getConCambioAuxiliar()) {
				tipoactivofijoempresa.setIsDeleted(tipoactivofijoempresa.getIsDeletedAuxiliar());	
				tipoactivofijoempresa.setIsNew(tipoactivofijoempresa.getIsNewAuxiliar());	
				tipoactivofijoempresa.setIsChanged(tipoactivofijoempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoactivofijoempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoactivofijoempresa.setIsDeletedAuxiliar(false);	
				tipoactivofijoempresa.setIsNewAuxiliar(false);	
				tipoactivofijoempresa.setIsChangedAuxiliar(false);
				
				tipoactivofijoempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoActivoFijoEmpresas(List<TipoActivoFijoEmpresa> tipoactivofijoempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa: tipoactivofijoempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresa tipoactivofijoempresaAux) throws Exception  {
		TipoActivoFijoEmpresaConstantesFunciones.InicializarValoresTipoActivoFijoEmpresa(tipoactivofijoempresaAux,true);
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa: tipoactivofijoempresas) {
			if(tipoactivofijoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoActivoFijoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoActivoFijoEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoActivoFijoEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoActivoFijoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoActivoFijoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresaAux: tipoactivofijoempresas) {
			if(tipoactivofijoempresaAux!=null && tipoactivofijoempresa!=null) {
				if((tipoactivofijoempresaAux.getId()==null && tipoactivofijoempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoactivofijoempresaAux.getId()!=null && tipoactivofijoempresa.getId()!=null){
					if(tipoactivofijoempresaAux.getId().equals(tipoactivofijoempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> tipoactivofijoempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoActivoFijoEmpresa tipoactivofijoempresa: tipoactivofijoempresas) {			
			if(tipoactivofijoempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoActivoFijoEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoActivoFijoEmpresaConstantesFunciones.LABEL_ID, TipoActivoFijoEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoActivoFijoEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoEmpresaConstantesFunciones.LABEL_CODIGO, TipoActivoFijoEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoEmpresaConstantesFunciones.LABEL_NOMBRE, TipoActivoFijoEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoActivoFijoEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijoEmpresa() throws Exception  {
		return TipoActivoFijoEmpresaConstantesFunciones.getTiposSeleccionarTipoActivoFijoEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijoEmpresa(Boolean conFk) throws Exception  {
		return TipoActivoFijoEmpresaConstantesFunciones.getTiposSeleccionarTipoActivoFijoEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijoEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoActivoFijoEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoActivoFijoEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoActivoFijoEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoActivoFijoEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoActivoFijoEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoActivoFijoEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoActivoFijoEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresaAux) throws Exception {
		
			tipoactivofijoempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoactivofijoempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> tipoactivofijoempresasTemp) throws Exception {
		for(TipoActivoFijoEmpresa tipoactivofijoempresaAux:tipoactivofijoempresasTemp) {
			
			tipoactivofijoempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoactivofijoempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoActivoFijoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoActivoFijoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoActivoFijoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoActivoFijoEmpresaConstantesFunciones.getClassesRelationshipsOfTipoActivoFijoEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoActivoFijoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoActivoFijoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoActivoFijoEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoActivoFijoEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoActivoFijoEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	public static void actualizarLista(TipoActivoFijoEmpresa tipoactivofijoempresa,List<TipoActivoFijoEmpresa> tipoactivofijoempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoActivoFijoEmpresa tipoactivofijoempresaEncontrado=null;
			
			for(TipoActivoFijoEmpresa tipoactivofijoempresaLocal:tipoactivofijoempresas) {
				if(tipoactivofijoempresaLocal.getId().equals(tipoactivofijoempresa.getId())) {
					tipoactivofijoempresaEncontrado=tipoactivofijoempresaLocal;
					
					tipoactivofijoempresaLocal.setIsChanged(tipoactivofijoempresa.getIsChanged());
					tipoactivofijoempresaLocal.setIsNew(tipoactivofijoempresa.getIsNew());
					tipoactivofijoempresaLocal.setIsDeleted(tipoactivofijoempresa.getIsDeleted());
					
					tipoactivofijoempresaLocal.setGeneralEntityOriginal(tipoactivofijoempresa.getGeneralEntityOriginal());
					
					tipoactivofijoempresaLocal.setId(tipoactivofijoempresa.getId());	
					tipoactivofijoempresaLocal.setVersionRow(tipoactivofijoempresa.getVersionRow());	
					tipoactivofijoempresaLocal.setid_empresa(tipoactivofijoempresa.getid_empresa());	
					tipoactivofijoempresaLocal.setcodigo(tipoactivofijoempresa.getcodigo());	
					tipoactivofijoempresaLocal.setnombre(tipoactivofijoempresa.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoactivofijoempresa.getIsDeleted()) {
				if(!existe) {
					tipoactivofijoempresas.add(tipoactivofijoempresa);
				}
			} else {
				if(tipoactivofijoempresaEncontrado!=null && permiteQuitar)  {
					tipoactivofijoempresas.remove(tipoactivofijoempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoActivoFijoEmpresa tipoactivofijoempresa,List<TipoActivoFijoEmpresa> tipoactivofijoempresas) throws Exception {
		try	{			
			for(TipoActivoFijoEmpresa tipoactivofijoempresaLocal:tipoactivofijoempresas) {
				if(tipoactivofijoempresaLocal.getId().equals(tipoactivofijoempresa.getId())) {
					tipoactivofijoempresaLocal.setIsSelected(tipoactivofijoempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> tipoactivofijoempresasAux) throws Exception {
		//this.tipoactivofijoempresasAux=tipoactivofijoempresasAux;
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresaAux:tipoactivofijoempresasAux) {
			if(tipoactivofijoempresaAux.getIsChanged()) {
				tipoactivofijoempresaAux.setIsChanged(false);
			}		
			
			if(tipoactivofijoempresaAux.getIsNew()) {
				tipoactivofijoempresaAux.setIsNew(false);
			}	
			
			if(tipoactivofijoempresaAux.getIsDeleted()) {
				tipoactivofijoempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresaAux) throws Exception {
		//this.tipoactivofijoempresaAux=tipoactivofijoempresaAux;
		
			if(tipoactivofijoempresaAux.getIsChanged()) {
				tipoactivofijoempresaAux.setIsChanged(false);
			}		
			
			if(tipoactivofijoempresaAux.getIsNew()) {
				tipoactivofijoempresaAux.setIsNew(false);
			}	
			
			if(tipoactivofijoempresaAux.getIsDeleted()) {
				tipoactivofijoempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoActivoFijoEmpresa tipoactivofijoempresaAsignar,TipoActivoFijoEmpresa tipoactivofijoempresa) throws Exception {
		tipoactivofijoempresaAsignar.setId(tipoactivofijoempresa.getId());	
		tipoactivofijoempresaAsignar.setVersionRow(tipoactivofijoempresa.getVersionRow());	
		tipoactivofijoempresaAsignar.setid_empresa(tipoactivofijoempresa.getid_empresa());
		tipoactivofijoempresaAsignar.setempresa_descripcion(tipoactivofijoempresa.getempresa_descripcion());	
		tipoactivofijoempresaAsignar.setcodigo(tipoactivofijoempresa.getcodigo());	
		tipoactivofijoempresaAsignar.setnombre(tipoactivofijoempresa.getnombre());	
	}
	
	public static void inicializarTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa) throws Exception {
		try {
				tipoactivofijoempresa.setId(0L);	
					
				tipoactivofijoempresa.setid_empresa(-1L);	
				tipoactivofijoempresa.setcodigo("");	
				tipoactivofijoempresa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoActivoFijoEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoActivoFijoEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoActivoFijoEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoActivoFijoEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoActivoFijoEmpresa(String sTipo,Row row,Workbook workbook,TipoActivoFijoEmpresa tipoactivofijoempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoactivofijoempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoactivofijoempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoactivofijoempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoActivoFijoEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoActivoFijoEmpresa() {
		return this.sFinalQueryTipoActivoFijoEmpresa;
	}
	
	public void setsFinalQueryTipoActivoFijoEmpresa(String sFinalQueryTipoActivoFijoEmpresa) {
		this.sFinalQueryTipoActivoFijoEmpresa= sFinalQueryTipoActivoFijoEmpresa;
	}
	
	public Border resaltarSeleccionarTipoActivoFijoEmpresa=null;
	
	public Border setResaltarSeleccionarTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoactivofijoempresaBeanSwingJInternalFrame.jTtoolBarTipoActivoFijoEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoActivoFijoEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoActivoFijoEmpresa() {
		return this.resaltarSeleccionarTipoActivoFijoEmpresa;
	}
	
	public void setResaltarSeleccionarTipoActivoFijoEmpresa(Border borderResaltarSeleccionarTipoActivoFijoEmpresa) {
		this.resaltarSeleccionarTipoActivoFijoEmpresa= borderResaltarSeleccionarTipoActivoFijoEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoActivoFijoEmpresa=null;
	public Boolean mostraridTipoActivoFijoEmpresa=true;
	public Boolean activaridTipoActivoFijoEmpresa=true;

	public Border resaltarid_empresaTipoActivoFijoEmpresa=null;
	public Boolean mostrarid_empresaTipoActivoFijoEmpresa=true;
	public Boolean activarid_empresaTipoActivoFijoEmpresa=true;
	public Boolean cargarid_empresaTipoActivoFijoEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoActivoFijoEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoTipoActivoFijoEmpresa=null;
	public Boolean mostrarcodigoTipoActivoFijoEmpresa=true;
	public Boolean activarcodigoTipoActivoFijoEmpresa=true;

	public Border resaltarnombreTipoActivoFijoEmpresa=null;
	public Boolean mostrarnombreTipoActivoFijoEmpresa=true;
	public Boolean activarnombreTipoActivoFijoEmpresa=true;

	
	

	public Border setResaltaridTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoempresaBeanSwingJInternalFrame.jTtoolBarTipoActivoFijoEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoActivoFijoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoActivoFijoEmpresa() {
		return this.resaltaridTipoActivoFijoEmpresa;
	}

	public void setResaltaridTipoActivoFijoEmpresa(Border borderResaltar) {
		this.resaltaridTipoActivoFijoEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoActivoFijoEmpresa() {
		return this.mostraridTipoActivoFijoEmpresa;
	}

	public void setMostraridTipoActivoFijoEmpresa(Boolean mostraridTipoActivoFijoEmpresa) {
		this.mostraridTipoActivoFijoEmpresa= mostraridTipoActivoFijoEmpresa;
	}

	public Boolean getActivaridTipoActivoFijoEmpresa() {
		return this.activaridTipoActivoFijoEmpresa;
	}

	public void setActivaridTipoActivoFijoEmpresa(Boolean activaridTipoActivoFijoEmpresa) {
		this.activaridTipoActivoFijoEmpresa= activaridTipoActivoFijoEmpresa;
	}

	public Border setResaltarid_empresaTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoempresaBeanSwingJInternalFrame.jTtoolBarTipoActivoFijoEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoActivoFijoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoActivoFijoEmpresa() {
		return this.resaltarid_empresaTipoActivoFijoEmpresa;
	}

	public void setResaltarid_empresaTipoActivoFijoEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoActivoFijoEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoActivoFijoEmpresa() {
		return this.mostrarid_empresaTipoActivoFijoEmpresa;
	}

	public void setMostrarid_empresaTipoActivoFijoEmpresa(Boolean mostrarid_empresaTipoActivoFijoEmpresa) {
		this.mostrarid_empresaTipoActivoFijoEmpresa= mostrarid_empresaTipoActivoFijoEmpresa;
	}

	public Boolean getActivarid_empresaTipoActivoFijoEmpresa() {
		return this.activarid_empresaTipoActivoFijoEmpresa;
	}

	public void setActivarid_empresaTipoActivoFijoEmpresa(Boolean activarid_empresaTipoActivoFijoEmpresa) {
		this.activarid_empresaTipoActivoFijoEmpresa= activarid_empresaTipoActivoFijoEmpresa;
	}

	public Boolean getCargarid_empresaTipoActivoFijoEmpresa() {
		return this.cargarid_empresaTipoActivoFijoEmpresa;
	}

	public void setCargarid_empresaTipoActivoFijoEmpresa(Boolean cargarid_empresaTipoActivoFijoEmpresa) {
		this.cargarid_empresaTipoActivoFijoEmpresa= cargarid_empresaTipoActivoFijoEmpresa;
	}

	public Border setResaltarcodigoTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoempresaBeanSwingJInternalFrame.jTtoolBarTipoActivoFijoEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoActivoFijoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoActivoFijoEmpresa() {
		return this.resaltarcodigoTipoActivoFijoEmpresa;
	}

	public void setResaltarcodigoTipoActivoFijoEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoActivoFijoEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoActivoFijoEmpresa() {
		return this.mostrarcodigoTipoActivoFijoEmpresa;
	}

	public void setMostrarcodigoTipoActivoFijoEmpresa(Boolean mostrarcodigoTipoActivoFijoEmpresa) {
		this.mostrarcodigoTipoActivoFijoEmpresa= mostrarcodigoTipoActivoFijoEmpresa;
	}

	public Boolean getActivarcodigoTipoActivoFijoEmpresa() {
		return this.activarcodigoTipoActivoFijoEmpresa;
	}

	public void setActivarcodigoTipoActivoFijoEmpresa(Boolean activarcodigoTipoActivoFijoEmpresa) {
		this.activarcodigoTipoActivoFijoEmpresa= activarcodigoTipoActivoFijoEmpresa;
	}

	public Border setResaltarnombreTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoempresaBeanSwingJInternalFrame.jTtoolBarTipoActivoFijoEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoActivoFijoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoActivoFijoEmpresa() {
		return this.resaltarnombreTipoActivoFijoEmpresa;
	}

	public void setResaltarnombreTipoActivoFijoEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoActivoFijoEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoActivoFijoEmpresa() {
		return this.mostrarnombreTipoActivoFijoEmpresa;
	}

	public void setMostrarnombreTipoActivoFijoEmpresa(Boolean mostrarnombreTipoActivoFijoEmpresa) {
		this.mostrarnombreTipoActivoFijoEmpresa= mostrarnombreTipoActivoFijoEmpresa;
	}

	public Boolean getActivarnombreTipoActivoFijoEmpresa() {
		return this.activarnombreTipoActivoFijoEmpresa;
	}

	public void setActivarnombreTipoActivoFijoEmpresa(Boolean activarnombreTipoActivoFijoEmpresa) {
		this.activarnombreTipoActivoFijoEmpresa= activarnombreTipoActivoFijoEmpresa;
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
		
		
		this.setMostraridTipoActivoFijoEmpresa(esInicial);
		this.setMostrarid_empresaTipoActivoFijoEmpresa(esInicial);
		this.setMostrarcodigoTipoActivoFijoEmpresa(esInicial);
		this.setMostrarnombreTipoActivoFijoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoActivoFijoEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoActivoFijoEmpresa(esInicial);
		this.setActivarid_empresaTipoActivoFijoEmpresa(esInicial);
		this.setActivarcodigoTipoActivoFijoEmpresa(esInicial);
		this.setActivarnombreTipoActivoFijoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoActivoFijoEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoActivoFijoEmpresa(esInicial);
		this.setResaltarid_empresaTipoActivoFijoEmpresa(esInicial);
		this.setResaltarcodigoTipoActivoFijoEmpresa(esInicial);
		this.setResaltarnombreTipoActivoFijoEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoActivoFijoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoActivoFijoEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoActivoFijoEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoActivoFijoEmpresa() {
		return this.mostrarFK_IdEmpresaTipoActivoFijoEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoActivoFijoEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoActivoFijoEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoActivoFijoEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoActivoFijoEmpresa() {
		return this.activarFK_IdEmpresaTipoActivoFijoEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoActivoFijoEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoActivoFijoEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoActivoFijoEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoActivoFijoEmpresa() {
		return this.resaltarFK_IdEmpresaTipoActivoFijoEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoActivoFijoEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoActivoFijoEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoActivoFijoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoEmpresaBeanSwingJInternalFrame tipoactivofijoempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoActivoFijoEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}