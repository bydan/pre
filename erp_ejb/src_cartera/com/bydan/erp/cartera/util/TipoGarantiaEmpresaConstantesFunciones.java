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


import com.bydan.erp.cartera.util.TipoGarantiaEmpresaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoGarantiaEmpresaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoGarantiaEmpresaParameterGeneral;

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
final public class TipoGarantiaEmpresaConstantesFunciones extends TipoGarantiaEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGarantiaEmpresa";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGarantiaEmpresa"+TipoGarantiaEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGarantiaEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGarantiaEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"_"+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGarantiaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"_"+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"_"+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGarantiaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"_"+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGarantiaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGarantiaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGarantiaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGarantiaEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGarantiaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGarantiaEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Garantia Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Garantia Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Garantia Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGarantiaEmpresa";
	public static final String OBJECTNAME="tipogarantiaempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_garantia_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogarantiaempresa from "+TipoGarantiaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogarantiaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".es_defecto from "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoGarantiaEmpresaConstantesFuncionesAdditional tipogarantiaempresaConstantesFuncionesAdditional=null;
	
	public TipoGarantiaEmpresaConstantesFuncionesAdditional getTipoGarantiaEmpresaConstantesFuncionesAdditional() {
		return this.tipogarantiaempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoGarantiaEmpresaConstantesFuncionesAdditional(TipoGarantiaEmpresaConstantesFuncionesAdditional tipogarantiaempresaConstantesFuncionesAdditional) {
		try {
			this.tipogarantiaempresaConstantesFuncionesAdditional=tipogarantiaempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
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
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoGarantiaEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoGarantiaEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoGarantiaEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoGarantiaEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGarantiaEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGarantiaEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO)) {sLabelColumna=TipoGarantiaEmpresaConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_defectoDescripcion(TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipogarantiaempresa.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipogarantiaempresa.getId(),tipogarantiaempresa.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getTipoGarantiaEmpresaDescripcion(TipoGarantiaEmpresa tipogarantiaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogarantiaempresa !=null/* && tipogarantiaempresa.getId()!=0*/) {
			sDescripcion=tipogarantiaempresa.getcodigo();//tipogarantiaempresatipogarantiaempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGarantiaEmpresaDescripcionDetallado(TipoGarantiaEmpresa tipogarantiaempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipogarantiaempresa.getId().toString()+",";
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogarantiaempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipogarantiaempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipogarantiaempresa.getcodigo()+",";
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogarantiaempresa.getnombre()+",";
		sDescripcion+=TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=tipogarantiaempresa.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGarantiaEmpresaDescripcion(TipoGarantiaEmpresa tipogarantiaempresa,String sValor) throws Exception {			
		if(tipogarantiaempresa !=null) {
			tipogarantiaempresa.setcodigo(sValor);;//tipogarantiaempresatipogarantiaempresa.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogarantiaempresa.setcodigo(tipogarantiaempresa.getcodigo().trim());
		tipogarantiaempresa.setnombre(tipogarantiaempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGarantiaEmpresas(List<TipoGarantiaEmpresa> tipogarantiaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGarantiaEmpresa tipogarantiaempresa: tipogarantiaempresas) {
			tipogarantiaempresa.setcodigo(tipogarantiaempresa.getcodigo().trim());
			tipogarantiaempresa.setnombre(tipogarantiaempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogarantiaempresa.getConCambioAuxiliar()) {
			tipogarantiaempresa.setIsDeleted(tipogarantiaempresa.getIsDeletedAuxiliar());	
			tipogarantiaempresa.setIsNew(tipogarantiaempresa.getIsNewAuxiliar());	
			tipogarantiaempresa.setIsChanged(tipogarantiaempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogarantiaempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogarantiaempresa.setIsDeletedAuxiliar(false);	
			tipogarantiaempresa.setIsNewAuxiliar(false);	
			tipogarantiaempresa.setIsChangedAuxiliar(false);
			
			tipogarantiaempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGarantiaEmpresas(List<TipoGarantiaEmpresa> tipogarantiaempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGarantiaEmpresa tipogarantiaempresa : tipogarantiaempresas) {
			if(conAsignarBase && tipogarantiaempresa.getConCambioAuxiliar()) {
				tipogarantiaempresa.setIsDeleted(tipogarantiaempresa.getIsDeletedAuxiliar());	
				tipogarantiaempresa.setIsNew(tipogarantiaempresa.getIsNewAuxiliar());	
				tipogarantiaempresa.setIsChanged(tipogarantiaempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogarantiaempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogarantiaempresa.setIsDeletedAuxiliar(false);	
				tipogarantiaempresa.setIsNewAuxiliar(false);	
				tipogarantiaempresa.setIsChangedAuxiliar(false);
				
				tipogarantiaempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGarantiaEmpresas(List<TipoGarantiaEmpresa> tipogarantiaempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoGarantiaEmpresa tipogarantiaempresa: tipogarantiaempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresa tipogarantiaempresaAux) throws Exception  {
		TipoGarantiaEmpresaConstantesFunciones.InicializarValoresTipoGarantiaEmpresa(tipogarantiaempresaAux,true);
		
		for(TipoGarantiaEmpresa tipogarantiaempresa: tipogarantiaempresas) {
			if(tipogarantiaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGarantiaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGarantiaEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoGarantiaEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGarantiaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGarantiaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresa tipogarantiaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGarantiaEmpresa tipogarantiaempresaAux: tipogarantiaempresas) {
			if(tipogarantiaempresaAux!=null && tipogarantiaempresa!=null) {
				if((tipogarantiaempresaAux.getId()==null && tipogarantiaempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogarantiaempresaAux.getId()!=null && tipogarantiaempresa.getId()!=null){
					if(tipogarantiaempresaAux.getId().equals(tipogarantiaempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> tipogarantiaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGarantiaEmpresa tipogarantiaempresa: tipogarantiaempresas) {			
			if(tipogarantiaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGarantiaEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_ID, TipoGarantiaEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoGarantiaEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_CODIGO, TipoGarantiaEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_NOMBRE, TipoGarantiaEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaEmpresaConstantesFunciones.LABEL_ESDEFECTO, TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGarantiaEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantiaEmpresa() throws Exception  {
		return TipoGarantiaEmpresaConstantesFunciones.getTiposSeleccionarTipoGarantiaEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantiaEmpresa(Boolean conFk) throws Exception  {
		return TipoGarantiaEmpresaConstantesFunciones.getTiposSeleccionarTipoGarantiaEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantiaEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoGarantiaEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGarantiaEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGarantiaEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaEmpresaConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(TipoGarantiaEmpresaConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGarantiaEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresaAux) throws Exception {
		
			tipogarantiaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogarantiaempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> tipogarantiaempresasTemp) throws Exception {
		for(TipoGarantiaEmpresa tipogarantiaempresaAux:tipogarantiaempresasTemp) {
			
			tipogarantiaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogarantiaempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGarantiaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGarantiaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGarantiaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGarantiaEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGarantiaEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGarantiaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(GarantiaCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GarantiaCliente.class)) {
						classes.add(new Classe(GarantiaCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGarantiaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGarantiaEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGarantiaEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGarantiaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
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
	public static void actualizarLista(TipoGarantiaEmpresa tipogarantiaempresa,List<TipoGarantiaEmpresa> tipogarantiaempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGarantiaEmpresa tipogarantiaempresaEncontrado=null;
			
			for(TipoGarantiaEmpresa tipogarantiaempresaLocal:tipogarantiaempresas) {
				if(tipogarantiaempresaLocal.getId().equals(tipogarantiaempresa.getId())) {
					tipogarantiaempresaEncontrado=tipogarantiaempresaLocal;
					
					tipogarantiaempresaLocal.setIsChanged(tipogarantiaempresa.getIsChanged());
					tipogarantiaempresaLocal.setIsNew(tipogarantiaempresa.getIsNew());
					tipogarantiaempresaLocal.setIsDeleted(tipogarantiaempresa.getIsDeleted());
					
					tipogarantiaempresaLocal.setGeneralEntityOriginal(tipogarantiaempresa.getGeneralEntityOriginal());
					
					tipogarantiaempresaLocal.setId(tipogarantiaempresa.getId());	
					tipogarantiaempresaLocal.setVersionRow(tipogarantiaempresa.getVersionRow());	
					tipogarantiaempresaLocal.setid_empresa(tipogarantiaempresa.getid_empresa());	
					tipogarantiaempresaLocal.setcodigo(tipogarantiaempresa.getcodigo());	
					tipogarantiaempresaLocal.setnombre(tipogarantiaempresa.getnombre());	
					tipogarantiaempresaLocal.setes_defecto(tipogarantiaempresa.getes_defecto());	
					
					
					tipogarantiaempresaLocal.setClientes(tipogarantiaempresa.getClientes());
					tipogarantiaempresaLocal.setGarantiaClientes(tipogarantiaempresa.getGarantiaClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!tipogarantiaempresa.getIsDeleted()) {
				if(!existe) {
					tipogarantiaempresas.add(tipogarantiaempresa);
				}
			} else {
				if(tipogarantiaempresaEncontrado!=null && permiteQuitar)  {
					tipogarantiaempresas.remove(tipogarantiaempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGarantiaEmpresa tipogarantiaempresa,List<TipoGarantiaEmpresa> tipogarantiaempresas) throws Exception {
		try	{			
			for(TipoGarantiaEmpresa tipogarantiaempresaLocal:tipogarantiaempresas) {
				if(tipogarantiaempresaLocal.getId().equals(tipogarantiaempresa.getId())) {
					tipogarantiaempresaLocal.setIsSelected(tipogarantiaempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> tipogarantiaempresasAux) throws Exception {
		//this.tipogarantiaempresasAux=tipogarantiaempresasAux;
		
		for(TipoGarantiaEmpresa tipogarantiaempresaAux:tipogarantiaempresasAux) {
			if(tipogarantiaempresaAux.getIsChanged()) {
				tipogarantiaempresaAux.setIsChanged(false);
			}		
			
			if(tipogarantiaempresaAux.getIsNew()) {
				tipogarantiaempresaAux.setIsNew(false);
			}	
			
			if(tipogarantiaempresaAux.getIsDeleted()) {
				tipogarantiaempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresaAux) throws Exception {
		//this.tipogarantiaempresaAux=tipogarantiaempresaAux;
		
			if(tipogarantiaempresaAux.getIsChanged()) {
				tipogarantiaempresaAux.setIsChanged(false);
			}		
			
			if(tipogarantiaempresaAux.getIsNew()) {
				tipogarantiaempresaAux.setIsNew(false);
			}	
			
			if(tipogarantiaempresaAux.getIsDeleted()) {
				tipogarantiaempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGarantiaEmpresa tipogarantiaempresaAsignar,TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		tipogarantiaempresaAsignar.setId(tipogarantiaempresa.getId());	
		tipogarantiaempresaAsignar.setVersionRow(tipogarantiaempresa.getVersionRow());	
		tipogarantiaempresaAsignar.setid_empresa(tipogarantiaempresa.getid_empresa());
		tipogarantiaempresaAsignar.setempresa_descripcion(tipogarantiaempresa.getempresa_descripcion());	
		tipogarantiaempresaAsignar.setcodigo(tipogarantiaempresa.getcodigo());	
		tipogarantiaempresaAsignar.setnombre(tipogarantiaempresa.getnombre());	
		tipogarantiaempresaAsignar.setes_defecto(tipogarantiaempresa.getes_defecto());	
	}
	
	public static void inicializarTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		try {
				tipogarantiaempresa.setId(0L);	
					
				tipogarantiaempresa.setid_empresa(-1L);	
				tipogarantiaempresa.setcodigo("");	
				tipogarantiaempresa.setnombre("");	
				tipogarantiaempresa.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGarantiaEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaEmpresaConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGarantiaEmpresa(String sTipo,Row row,Workbook workbook,TipoGarantiaEmpresa tipogarantiaempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantiaempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantiaempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantiaempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipogarantiaempresa.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGarantiaEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGarantiaEmpresa() {
		return this.sFinalQueryTipoGarantiaEmpresa;
	}
	
	public void setsFinalQueryTipoGarantiaEmpresa(String sFinalQueryTipoGarantiaEmpresa) {
		this.sFinalQueryTipoGarantiaEmpresa= sFinalQueryTipoGarantiaEmpresa;
	}
	
	public Border resaltarSeleccionarTipoGarantiaEmpresa=null;
	
	public Border setResaltarSeleccionarTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGarantiaEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGarantiaEmpresa() {
		return this.resaltarSeleccionarTipoGarantiaEmpresa;
	}
	
	public void setResaltarSeleccionarTipoGarantiaEmpresa(Border borderResaltarSeleccionarTipoGarantiaEmpresa) {
		this.resaltarSeleccionarTipoGarantiaEmpresa= borderResaltarSeleccionarTipoGarantiaEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGarantiaEmpresa=null;
	public Boolean mostraridTipoGarantiaEmpresa=true;
	public Boolean activaridTipoGarantiaEmpresa=true;

	public Border resaltarid_empresaTipoGarantiaEmpresa=null;
	public Boolean mostrarid_empresaTipoGarantiaEmpresa=true;
	public Boolean activarid_empresaTipoGarantiaEmpresa=true;
	public Boolean cargarid_empresaTipoGarantiaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoGarantiaEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoTipoGarantiaEmpresa=null;
	public Boolean mostrarcodigoTipoGarantiaEmpresa=true;
	public Boolean activarcodigoTipoGarantiaEmpresa=true;

	public Border resaltarnombreTipoGarantiaEmpresa=null;
	public Boolean mostrarnombreTipoGarantiaEmpresa=true;
	public Boolean activarnombreTipoGarantiaEmpresa=true;

	public Border resaltares_defectoTipoGarantiaEmpresa=null;
	public Boolean mostrares_defectoTipoGarantiaEmpresa=true;
	public Boolean activares_defectoTipoGarantiaEmpresa=true;

	
	

	public Border setResaltaridTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoGarantiaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGarantiaEmpresa() {
		return this.resaltaridTipoGarantiaEmpresa;
	}

	public void setResaltaridTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltaridTipoGarantiaEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoGarantiaEmpresa() {
		return this.mostraridTipoGarantiaEmpresa;
	}

	public void setMostraridTipoGarantiaEmpresa(Boolean mostraridTipoGarantiaEmpresa) {
		this.mostraridTipoGarantiaEmpresa= mostraridTipoGarantiaEmpresa;
	}

	public Boolean getActivaridTipoGarantiaEmpresa() {
		return this.activaridTipoGarantiaEmpresa;
	}

	public void setActivaridTipoGarantiaEmpresa(Boolean activaridTipoGarantiaEmpresa) {
		this.activaridTipoGarantiaEmpresa= activaridTipoGarantiaEmpresa;
	}

	public Border setResaltarid_empresaTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoGarantiaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoGarantiaEmpresa() {
		return this.resaltarid_empresaTipoGarantiaEmpresa;
	}

	public void setResaltarid_empresaTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoGarantiaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoGarantiaEmpresa() {
		return this.mostrarid_empresaTipoGarantiaEmpresa;
	}

	public void setMostrarid_empresaTipoGarantiaEmpresa(Boolean mostrarid_empresaTipoGarantiaEmpresa) {
		this.mostrarid_empresaTipoGarantiaEmpresa= mostrarid_empresaTipoGarantiaEmpresa;
	}

	public Boolean getActivarid_empresaTipoGarantiaEmpresa() {
		return this.activarid_empresaTipoGarantiaEmpresa;
	}

	public void setActivarid_empresaTipoGarantiaEmpresa(Boolean activarid_empresaTipoGarantiaEmpresa) {
		this.activarid_empresaTipoGarantiaEmpresa= activarid_empresaTipoGarantiaEmpresa;
	}

	public Boolean getCargarid_empresaTipoGarantiaEmpresa() {
		return this.cargarid_empresaTipoGarantiaEmpresa;
	}

	public void setCargarid_empresaTipoGarantiaEmpresa(Boolean cargarid_empresaTipoGarantiaEmpresa) {
		this.cargarid_empresaTipoGarantiaEmpresa= cargarid_empresaTipoGarantiaEmpresa;
	}

	public Border setResaltarcodigoTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGarantiaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGarantiaEmpresa() {
		return this.resaltarcodigoTipoGarantiaEmpresa;
	}

	public void setResaltarcodigoTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoGarantiaEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGarantiaEmpresa() {
		return this.mostrarcodigoTipoGarantiaEmpresa;
	}

	public void setMostrarcodigoTipoGarantiaEmpresa(Boolean mostrarcodigoTipoGarantiaEmpresa) {
		this.mostrarcodigoTipoGarantiaEmpresa= mostrarcodigoTipoGarantiaEmpresa;
	}

	public Boolean getActivarcodigoTipoGarantiaEmpresa() {
		return this.activarcodigoTipoGarantiaEmpresa;
	}

	public void setActivarcodigoTipoGarantiaEmpresa(Boolean activarcodigoTipoGarantiaEmpresa) {
		this.activarcodigoTipoGarantiaEmpresa= activarcodigoTipoGarantiaEmpresa;
	}

	public Border setResaltarnombreTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGarantiaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGarantiaEmpresa() {
		return this.resaltarnombreTipoGarantiaEmpresa;
	}

	public void setResaltarnombreTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoGarantiaEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGarantiaEmpresa() {
		return this.mostrarnombreTipoGarantiaEmpresa;
	}

	public void setMostrarnombreTipoGarantiaEmpresa(Boolean mostrarnombreTipoGarantiaEmpresa) {
		this.mostrarnombreTipoGarantiaEmpresa= mostrarnombreTipoGarantiaEmpresa;
	}

	public Boolean getActivarnombreTipoGarantiaEmpresa() {
		return this.activarnombreTipoGarantiaEmpresa;
	}

	public void setActivarnombreTipoGarantiaEmpresa(Boolean activarnombreTipoGarantiaEmpresa) {
		this.activarnombreTipoGarantiaEmpresa= activarnombreTipoGarantiaEmpresa;
	}

	public Border setResaltares_defectoTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltar);
		
		this.resaltares_defectoTipoGarantiaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoTipoGarantiaEmpresa() {
		return this.resaltares_defectoTipoGarantiaEmpresa;
	}

	public void setResaltares_defectoTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltares_defectoTipoGarantiaEmpresa= borderResaltar;
	}

	public Boolean getMostrares_defectoTipoGarantiaEmpresa() {
		return this.mostrares_defectoTipoGarantiaEmpresa;
	}

	public void setMostrares_defectoTipoGarantiaEmpresa(Boolean mostrares_defectoTipoGarantiaEmpresa) {
		this.mostrares_defectoTipoGarantiaEmpresa= mostrares_defectoTipoGarantiaEmpresa;
	}

	public Boolean getActivares_defectoTipoGarantiaEmpresa() {
		return this.activares_defectoTipoGarantiaEmpresa;
	}

	public void setActivares_defectoTipoGarantiaEmpresa(Boolean activares_defectoTipoGarantiaEmpresa) {
		this.activares_defectoTipoGarantiaEmpresa= activares_defectoTipoGarantiaEmpresa;
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
		
		
		this.setMostraridTipoGarantiaEmpresa(esInicial);
		this.setMostrarid_empresaTipoGarantiaEmpresa(esInicial);
		this.setMostrarcodigoTipoGarantiaEmpresa(esInicial);
		this.setMostrarnombreTipoGarantiaEmpresa(esInicial);
		this.setMostrares_defectoTipoGarantiaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoTipoGarantiaEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoGarantiaEmpresa(esInicial);
		this.setActivarid_empresaTipoGarantiaEmpresa(esInicial);
		this.setActivarcodigoTipoGarantiaEmpresa(esInicial);
		this.setActivarnombreTipoGarantiaEmpresa(esInicial);
		this.setActivares_defectoTipoGarantiaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoTipoGarantiaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGarantiaEmpresa(esInicial);
		this.setResaltarid_empresaTipoGarantiaEmpresa(esInicial);
		this.setResaltarcodigoTipoGarantiaEmpresa(esInicial);
		this.setResaltarnombreTipoGarantiaEmpresa(esInicial);
		this.setResaltares_defectoTipoGarantiaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoTipoGarantiaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTipoGarantiaEmpresa=null;

	public Border getResaltarClienteTipoGarantiaEmpresa() {
		return this.resaltarClienteTipoGarantiaEmpresa;
	}

	public void setResaltarClienteTipoGarantiaEmpresa(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoGarantiaEmpresa= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoGarantiaEmpresa= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoGarantiaEmpresa=true;

	public Boolean getMostrarClienteTipoGarantiaEmpresa() {
		return this.mostrarClienteTipoGarantiaEmpresa;
	}

	public void setMostrarClienteTipoGarantiaEmpresa(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoGarantiaEmpresa= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoGarantiaEmpresa=true;

	public Boolean gethabilitarResaltarClienteTipoGarantiaEmpresa() {
		return this.activarClienteTipoGarantiaEmpresa;
	}

	public void setActivarClienteTipoGarantiaEmpresa(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoGarantiaEmpresa= habilitarResaltarCliente;
	}


	public Border resaltarGarantiaClienteTipoGarantiaEmpresa=null;

	public Border getResaltarGarantiaClienteTipoGarantiaEmpresa() {
		return this.resaltarGarantiaClienteTipoGarantiaEmpresa;
	}

	public void setResaltarGarantiaClienteTipoGarantiaEmpresa(Border borderResaltarGarantiaCliente) {
		if(borderResaltarGarantiaCliente!=null) {
			this.resaltarGarantiaClienteTipoGarantiaEmpresa= borderResaltarGarantiaCliente;
		}
	}

	public Border setResaltarGarantiaClienteTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarGarantiaCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogarantiaempresaBeanSwingJInternalFrame.jTtoolBarTipoGarantiaEmpresa.setBorder(borderResaltarGarantiaCliente);
			
		this.resaltarGarantiaClienteTipoGarantiaEmpresa= borderResaltarGarantiaCliente;

		 return borderResaltarGarantiaCliente;
	}



	public Boolean mostrarGarantiaClienteTipoGarantiaEmpresa=true;

	public Boolean getMostrarGarantiaClienteTipoGarantiaEmpresa() {
		return this.mostrarGarantiaClienteTipoGarantiaEmpresa;
	}

	public void setMostrarGarantiaClienteTipoGarantiaEmpresa(Boolean visibilidadResaltarGarantiaCliente) {
		this.mostrarGarantiaClienteTipoGarantiaEmpresa= visibilidadResaltarGarantiaCliente;
	}



	public Boolean activarGarantiaClienteTipoGarantiaEmpresa=true;

	public Boolean gethabilitarResaltarGarantiaClienteTipoGarantiaEmpresa() {
		return this.activarGarantiaClienteTipoGarantiaEmpresa;
	}

	public void setActivarGarantiaClienteTipoGarantiaEmpresa(Boolean habilitarResaltarGarantiaCliente) {
		this.activarGarantiaClienteTipoGarantiaEmpresa= habilitarResaltarGarantiaCliente;
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

		this.setMostrarClienteTipoGarantiaEmpresa(esInicial);
		this.setMostrarGarantiaClienteTipoGarantiaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setMostrarGarantiaClienteTipoGarantiaEmpresa(esAsigna);
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

		this.setActivarClienteTipoGarantiaEmpresa(esInicial);
		this.setActivarGarantiaClienteTipoGarantiaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setActivarGarantiaClienteTipoGarantiaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTipoGarantiaEmpresa(esInicial);
		this.setResaltarGarantiaClienteTipoGarantiaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoGarantiaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setResaltarGarantiaClienteTipoGarantiaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoGarantiaEmpresa=true;

	public Boolean getMostrarBusquedaPorCodigoTipoGarantiaEmpresa() {
		return this.mostrarBusquedaPorCodigoTipoGarantiaEmpresa;
	}

	public void setMostrarBusquedaPorCodigoTipoGarantiaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoGarantiaEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoGarantiaEmpresa=true;

	public Boolean getMostrarBusquedaPorNombreTipoGarantiaEmpresa() {
		return this.mostrarBusquedaPorNombreTipoGarantiaEmpresa;
	}

	public void setMostrarBusquedaPorNombreTipoGarantiaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGarantiaEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoGarantiaEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoGarantiaEmpresa() {
		return this.mostrarFK_IdEmpresaTipoGarantiaEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoGarantiaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoGarantiaEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoGarantiaEmpresa=true;

	public Boolean getActivarBusquedaPorCodigoTipoGarantiaEmpresa() {
		return this.activarBusquedaPorCodigoTipoGarantiaEmpresa;
	}

	public void setActivarBusquedaPorCodigoTipoGarantiaEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoGarantiaEmpresa= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoGarantiaEmpresa=true;

	public Boolean getActivarBusquedaPorNombreTipoGarantiaEmpresa() {
		return this.activarBusquedaPorNombreTipoGarantiaEmpresa;
	}

	public void setActivarBusquedaPorNombreTipoGarantiaEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGarantiaEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoGarantiaEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoGarantiaEmpresa() {
		return this.activarFK_IdEmpresaTipoGarantiaEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoGarantiaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoGarantiaEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoGarantiaEmpresa=null;

	public Border getResaltarBusquedaPorCodigoTipoGarantiaEmpresa() {
		return this.resaltarBusquedaPorCodigoTipoGarantiaEmpresa;
	}

	public void setResaltarBusquedaPorCodigoTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoGarantiaEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoGarantiaEmpresa= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoGarantiaEmpresa=null;

	public Border getResaltarBusquedaPorNombreTipoGarantiaEmpresa() {
		return this.resaltarBusquedaPorNombreTipoGarantiaEmpresa;
	}

	public void setResaltarBusquedaPorNombreTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGarantiaEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGarantiaEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoGarantiaEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoGarantiaEmpresa() {
		return this.resaltarFK_IdEmpresaTipoGarantiaEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoGarantiaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoGarantiaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoGarantiaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaEmpresaBeanSwingJInternalFrame tipogarantiaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoGarantiaEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}