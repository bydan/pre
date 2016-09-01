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


import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPrioridadEmpresaProduConstantesFunciones extends TipoPrioridadEmpresaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPrioridadEmpresaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPrioridadEmpresaProdu"+TipoPrioridadEmpresaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPrioridadEmpresaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPrioridadEmpresaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrioridadEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrioridadEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrioridadEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrioridadEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPrioridadEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPrioridadEmpresaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPrioridadEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPrioridadEmpresaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Prioridad Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Prioridad Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Prioridad Empresa Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPrioridadEmpresaProdu";
	public static final String OBJECTNAME="tipoprioridadempresaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_prioridad_empresa_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprioridadempresaprodu from "+TipoPrioridadEmpresaProduConstantesFunciones.SPERSISTENCENAME+" tipoprioridadempresaprodu";
	public static String QUERYSELECTNATIVE="select "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".nombre,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".descripcion from "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPrioridadEmpresaProduConstantesFuncionesAdditional tipoprioridadempresaproduConstantesFuncionesAdditional=null;
	
	public TipoPrioridadEmpresaProduConstantesFuncionesAdditional getTipoPrioridadEmpresaProduConstantesFuncionesAdditional() {
		return this.tipoprioridadempresaproduConstantesFuncionesAdditional;
	}
	
	public void setTipoPrioridadEmpresaProduConstantesFuncionesAdditional(TipoPrioridadEmpresaProduConstantesFuncionesAdditional tipoprioridadempresaproduConstantesFuncionesAdditional) {
		try {
			this.tipoprioridadempresaproduConstantesFuncionesAdditional=tipoprioridadempresaproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoPrioridadEmpresaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPrioridadEmpresaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPrioridadEmpresaProduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoPrioridadEmpresaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoPrioridadEmpresaProduDescripcion(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprioridadempresaprodu !=null/* && tipoprioridadempresaprodu.getId()!=0*/) {
			sDescripcion=tipoprioridadempresaprodu.getnombre();//tipoprioridadempresaprodutipoprioridadempresaprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPrioridadEmpresaProduDescripcionDetallado(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) {
		String sDescripcion="";
			
		sDescripcion+=TipoPrioridadEmpresaProduConstantesFunciones.ID+"=";
		sDescripcion+=tipoprioridadempresaprodu.getId().toString()+",";
		sDescripcion+=TipoPrioridadEmpresaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprioridadempresaprodu.getVersionRow().toString()+",";
		sDescripcion+=TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoprioridadempresaprodu.getid_empresa().toString()+",";
		sDescripcion+=TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprioridadempresaprodu.getnombre()+",";
		sDescripcion+=TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoprioridadempresaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPrioridadEmpresaProduDescripcion(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,String sValor) throws Exception {			
		if(tipoprioridadempresaprodu !=null) {
			tipoprioridadempresaprodu.setnombre(sValor);;//tipoprioridadempresaprodutipoprioridadempresaprodu.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprioridadempresaprodu.setnombre(tipoprioridadempresaprodu.getnombre().trim());
		tipoprioridadempresaprodu.setdescripcion(tipoprioridadempresaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {
			tipoprioridadempresaprodu.setnombre(tipoprioridadempresaprodu.getnombre().trim());
			tipoprioridadempresaprodu.setdescripcion(tipoprioridadempresaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprioridadempresaprodu.getConCambioAuxiliar()) {
			tipoprioridadempresaprodu.setIsDeleted(tipoprioridadempresaprodu.getIsDeletedAuxiliar());	
			tipoprioridadempresaprodu.setIsNew(tipoprioridadempresaprodu.getIsNewAuxiliar());	
			tipoprioridadempresaprodu.setIsChanged(tipoprioridadempresaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprioridadempresaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprioridadempresaprodu.setIsDeletedAuxiliar(false);	
			tipoprioridadempresaprodu.setIsNewAuxiliar(false);	
			tipoprioridadempresaprodu.setIsChangedAuxiliar(false);
			
			tipoprioridadempresaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu : tipoprioridadempresaprodus) {
			if(conAsignarBase && tipoprioridadempresaprodu.getConCambioAuxiliar()) {
				tipoprioridadempresaprodu.setIsDeleted(tipoprioridadempresaprodu.getIsDeletedAuxiliar());	
				tipoprioridadempresaprodu.setIsNew(tipoprioridadempresaprodu.getIsNewAuxiliar());	
				tipoprioridadempresaprodu.setIsChanged(tipoprioridadempresaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprioridadempresaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprioridadempresaprodu.setIsDeletedAuxiliar(false);	
				tipoprioridadempresaprodu.setIsNewAuxiliar(false);	
				tipoprioridadempresaprodu.setIsChangedAuxiliar(false);
				
				tipoprioridadempresaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,Boolean conEnteros) throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux) throws Exception  {
		TipoPrioridadEmpresaProduConstantesFunciones.InicializarValoresTipoPrioridadEmpresaProdu(tipoprioridadempresaproduAux,true);
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {
			if(tipoprioridadempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrioridadEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPrioridadEmpresaProduConstantesFunciones.getArrayColumnasGlobalesTipoPrioridadEmpresaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrioridadEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPrioridadEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux: tipoprioridadempresaprodus) {
			if(tipoprioridadempresaproduAux!=null && tipoprioridadempresaprodu!=null) {
				if((tipoprioridadempresaproduAux.getId()==null && tipoprioridadempresaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprioridadempresaproduAux.getId()!=null && tipoprioridadempresaprodu.getId()!=null){
					if(tipoprioridadempresaproduAux.getId().equals(tipoprioridadempresaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {			
			if(tipoprioridadempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPrioridadEmpresaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPrioridadEmpresaProduConstantesFunciones.LABEL_ID, TipoPrioridadEmpresaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadEmpresaProduConstantesFunciones.LABEL_VERSIONROW, TipoPrioridadEmpresaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadEmpresaProduConstantesFunciones.LABEL_IDEMPRESA, TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadEmpresaProduConstantesFunciones.LABEL_NOMBRE, TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadEmpresaProduConstantesFunciones.LABEL_DESCRIPCION, TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPrioridadEmpresaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadEmpresaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadEmpresaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadEmpresaProdu() throws Exception  {
		return TipoPrioridadEmpresaProduConstantesFunciones.getTiposSeleccionarTipoPrioridadEmpresaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadEmpresaProdu(Boolean conFk) throws Exception  {
		return TipoPrioridadEmpresaProduConstantesFunciones.getTiposSeleccionarTipoPrioridadEmpresaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadEmpresaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPrioridadEmpresaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux) throws Exception {
		
			tipoprioridadempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprioridadempresaproduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusTemp) throws Exception {
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux:tipoprioridadempresaprodusTemp) {
			
			tipoprioridadempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprioridadempresaproduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrioridadEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPrioridadEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrioridadEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoPrioridadEmpresaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenProdu.class));
				classes.add(new Classe(PedidoProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenProdu.class)) {
						classes.add(new Classe(OrdenProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoProdu.class)) {
						classes.add(new Classe(PedidoProdu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrioridadEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrioridadEmpresaProduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPrioridadEmpresaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrioridadEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
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
	public static void actualizarLista(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPrioridadEmpresaProdu tipoprioridadempresaproduEncontrado=null;
			
			for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal:tipoprioridadempresaprodus) {
				if(tipoprioridadempresaproduLocal.getId().equals(tipoprioridadempresaprodu.getId())) {
					tipoprioridadempresaproduEncontrado=tipoprioridadempresaproduLocal;
					
					tipoprioridadempresaproduLocal.setIsChanged(tipoprioridadempresaprodu.getIsChanged());
					tipoprioridadempresaproduLocal.setIsNew(tipoprioridadempresaprodu.getIsNew());
					tipoprioridadempresaproduLocal.setIsDeleted(tipoprioridadempresaprodu.getIsDeleted());
					
					tipoprioridadempresaproduLocal.setGeneralEntityOriginal(tipoprioridadempresaprodu.getGeneralEntityOriginal());
					
					tipoprioridadempresaproduLocal.setId(tipoprioridadempresaprodu.getId());	
					tipoprioridadempresaproduLocal.setVersionRow(tipoprioridadempresaprodu.getVersionRow());	
					tipoprioridadempresaproduLocal.setid_empresa(tipoprioridadempresaprodu.getid_empresa());	
					tipoprioridadempresaproduLocal.setnombre(tipoprioridadempresaprodu.getnombre());	
					tipoprioridadempresaproduLocal.setdescripcion(tipoprioridadempresaprodu.getdescripcion());	
					
					
					tipoprioridadempresaproduLocal.setOrdenProdus(tipoprioridadempresaprodu.getOrdenProdus());
					tipoprioridadempresaproduLocal.setPedidoProdus(tipoprioridadempresaprodu.getPedidoProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprioridadempresaprodu.getIsDeleted()) {
				if(!existe) {
					tipoprioridadempresaprodus.add(tipoprioridadempresaprodu);
				}
			} else {
				if(tipoprioridadempresaproduEncontrado!=null && permiteQuitar)  {
					tipoprioridadempresaprodus.remove(tipoprioridadempresaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus) throws Exception {
		try	{			
			for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal:tipoprioridadempresaprodus) {
				if(tipoprioridadempresaproduLocal.getId().equals(tipoprioridadempresaprodu.getId())) {
					tipoprioridadempresaproduLocal.setIsSelected(tipoprioridadempresaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusAux) throws Exception {
		//this.tipoprioridadempresaprodusAux=tipoprioridadempresaprodusAux;
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux:tipoprioridadempresaprodusAux) {
			if(tipoprioridadempresaproduAux.getIsChanged()) {
				tipoprioridadempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoprioridadempresaproduAux.getIsNew()) {
				tipoprioridadempresaproduAux.setIsNew(false);
			}	
			
			if(tipoprioridadempresaproduAux.getIsDeleted()) {
				tipoprioridadempresaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux) throws Exception {
		//this.tipoprioridadempresaproduAux=tipoprioridadempresaproduAux;
		
			if(tipoprioridadempresaproduAux.getIsChanged()) {
				tipoprioridadempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoprioridadempresaproduAux.getIsNew()) {
				tipoprioridadempresaproduAux.setIsNew(false);
			}	
			
			if(tipoprioridadempresaproduAux.getIsDeleted()) {
				tipoprioridadempresaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAsignar,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) throws Exception {
		tipoprioridadempresaproduAsignar.setId(tipoprioridadempresaprodu.getId());	
		tipoprioridadempresaproduAsignar.setVersionRow(tipoprioridadempresaprodu.getVersionRow());	
		tipoprioridadempresaproduAsignar.setid_empresa(tipoprioridadempresaprodu.getid_empresa());
		tipoprioridadempresaproduAsignar.setempresa_descripcion(tipoprioridadempresaprodu.getempresa_descripcion());	
		tipoprioridadempresaproduAsignar.setnombre(tipoprioridadempresaprodu.getnombre());	
		tipoprioridadempresaproduAsignar.setdescripcion(tipoprioridadempresaprodu.getdescripcion());	
	}
	
	public static void inicializarTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) throws Exception {
		try {
				tipoprioridadempresaprodu.setId(0L);	
					
				tipoprioridadempresaprodu.setid_empresa(-1L);	
				tipoprioridadempresaprodu.setnombre("");	
				tipoprioridadempresaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPrioridadEmpresaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrioridadEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPrioridadEmpresaProdu(String sTipo,Row row,Workbook workbook,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprioridadempresaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprioridadempresaprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprioridadempresaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPrioridadEmpresaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPrioridadEmpresaProdu() {
		return this.sFinalQueryTipoPrioridadEmpresaProdu;
	}
	
	public void setsFinalQueryTipoPrioridadEmpresaProdu(String sFinalQueryTipoPrioridadEmpresaProdu) {
		this.sFinalQueryTipoPrioridadEmpresaProdu= sFinalQueryTipoPrioridadEmpresaProdu;
	}
	
	public Border resaltarSeleccionarTipoPrioridadEmpresaProdu=null;
	
	public Border setResaltarSeleccionarTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPrioridadEmpresaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPrioridadEmpresaProdu() {
		return this.resaltarSeleccionarTipoPrioridadEmpresaProdu;
	}
	
	public void setResaltarSeleccionarTipoPrioridadEmpresaProdu(Border borderResaltarSeleccionarTipoPrioridadEmpresaProdu) {
		this.resaltarSeleccionarTipoPrioridadEmpresaProdu= borderResaltarSeleccionarTipoPrioridadEmpresaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPrioridadEmpresaProdu=null;
	public Boolean mostraridTipoPrioridadEmpresaProdu=true;
	public Boolean activaridTipoPrioridadEmpresaProdu=true;

	public Border resaltarid_empresaTipoPrioridadEmpresaProdu=null;
	public Boolean mostrarid_empresaTipoPrioridadEmpresaProdu=true;
	public Boolean activarid_empresaTipoPrioridadEmpresaProdu=true;
	public Boolean cargarid_empresaTipoPrioridadEmpresaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPrioridadEmpresaProdu=false;//ConEventDepend=true

	public Border resaltarnombreTipoPrioridadEmpresaProdu=null;
	public Boolean mostrarnombreTipoPrioridadEmpresaProdu=true;
	public Boolean activarnombreTipoPrioridadEmpresaProdu=true;

	public Border resaltardescripcionTipoPrioridadEmpresaProdu=null;
	public Boolean mostrardescripcionTipoPrioridadEmpresaProdu=true;
	public Boolean activardescripcionTipoPrioridadEmpresaProdu=true;

	
	

	public Border setResaltaridTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltaridTipoPrioridadEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPrioridadEmpresaProdu() {
		return this.resaltaridTipoPrioridadEmpresaProdu;
	}

	public void setResaltaridTipoPrioridadEmpresaProdu(Border borderResaltar) {
		this.resaltaridTipoPrioridadEmpresaProdu= borderResaltar;
	}

	public Boolean getMostraridTipoPrioridadEmpresaProdu() {
		return this.mostraridTipoPrioridadEmpresaProdu;
	}

	public void setMostraridTipoPrioridadEmpresaProdu(Boolean mostraridTipoPrioridadEmpresaProdu) {
		this.mostraridTipoPrioridadEmpresaProdu= mostraridTipoPrioridadEmpresaProdu;
	}

	public Boolean getActivaridTipoPrioridadEmpresaProdu() {
		return this.activaridTipoPrioridadEmpresaProdu;
	}

	public void setActivaridTipoPrioridadEmpresaProdu(Boolean activaridTipoPrioridadEmpresaProdu) {
		this.activaridTipoPrioridadEmpresaProdu= activaridTipoPrioridadEmpresaProdu;
	}

	public Border setResaltarid_empresaTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPrioridadEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPrioridadEmpresaProdu() {
		return this.resaltarid_empresaTipoPrioridadEmpresaProdu;
	}

	public void setResaltarid_empresaTipoPrioridadEmpresaProdu(Border borderResaltar) {
		this.resaltarid_empresaTipoPrioridadEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPrioridadEmpresaProdu() {
		return this.mostrarid_empresaTipoPrioridadEmpresaProdu;
	}

	public void setMostrarid_empresaTipoPrioridadEmpresaProdu(Boolean mostrarid_empresaTipoPrioridadEmpresaProdu) {
		this.mostrarid_empresaTipoPrioridadEmpresaProdu= mostrarid_empresaTipoPrioridadEmpresaProdu;
	}

	public Boolean getActivarid_empresaTipoPrioridadEmpresaProdu() {
		return this.activarid_empresaTipoPrioridadEmpresaProdu;
	}

	public void setActivarid_empresaTipoPrioridadEmpresaProdu(Boolean activarid_empresaTipoPrioridadEmpresaProdu) {
		this.activarid_empresaTipoPrioridadEmpresaProdu= activarid_empresaTipoPrioridadEmpresaProdu;
	}

	public Boolean getCargarid_empresaTipoPrioridadEmpresaProdu() {
		return this.cargarid_empresaTipoPrioridadEmpresaProdu;
	}

	public void setCargarid_empresaTipoPrioridadEmpresaProdu(Boolean cargarid_empresaTipoPrioridadEmpresaProdu) {
		this.cargarid_empresaTipoPrioridadEmpresaProdu= cargarid_empresaTipoPrioridadEmpresaProdu;
	}

	public Border setResaltarnombreTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPrioridadEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPrioridadEmpresaProdu() {
		return this.resaltarnombreTipoPrioridadEmpresaProdu;
	}

	public void setResaltarnombreTipoPrioridadEmpresaProdu(Border borderResaltar) {
		this.resaltarnombreTipoPrioridadEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPrioridadEmpresaProdu() {
		return this.mostrarnombreTipoPrioridadEmpresaProdu;
	}

	public void setMostrarnombreTipoPrioridadEmpresaProdu(Boolean mostrarnombreTipoPrioridadEmpresaProdu) {
		this.mostrarnombreTipoPrioridadEmpresaProdu= mostrarnombreTipoPrioridadEmpresaProdu;
	}

	public Boolean getActivarnombreTipoPrioridadEmpresaProdu() {
		return this.activarnombreTipoPrioridadEmpresaProdu;
	}

	public void setActivarnombreTipoPrioridadEmpresaProdu(Boolean activarnombreTipoPrioridadEmpresaProdu) {
		this.activarnombreTipoPrioridadEmpresaProdu= activarnombreTipoPrioridadEmpresaProdu;
	}

	public Border setResaltardescripcionTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoPrioridadEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoPrioridadEmpresaProdu() {
		return this.resaltardescripcionTipoPrioridadEmpresaProdu;
	}

	public void setResaltardescripcionTipoPrioridadEmpresaProdu(Border borderResaltar) {
		this.resaltardescripcionTipoPrioridadEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoPrioridadEmpresaProdu() {
		return this.mostrardescripcionTipoPrioridadEmpresaProdu;
	}

	public void setMostrardescripcionTipoPrioridadEmpresaProdu(Boolean mostrardescripcionTipoPrioridadEmpresaProdu) {
		this.mostrardescripcionTipoPrioridadEmpresaProdu= mostrardescripcionTipoPrioridadEmpresaProdu;
	}

	public Boolean getActivardescripcionTipoPrioridadEmpresaProdu() {
		return this.activardescripcionTipoPrioridadEmpresaProdu;
	}

	public void setActivardescripcionTipoPrioridadEmpresaProdu(Boolean activardescripcionTipoPrioridadEmpresaProdu) {
		this.activardescripcionTipoPrioridadEmpresaProdu= activardescripcionTipoPrioridadEmpresaProdu;
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
		
		
		this.setMostraridTipoPrioridadEmpresaProdu(esInicial);
		this.setMostrarid_empresaTipoPrioridadEmpresaProdu(esInicial);
		this.setMostrarnombreTipoPrioridadEmpresaProdu(esInicial);
		this.setMostrardescripcionTipoPrioridadEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.ID)) {
				this.setMostraridTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoPrioridadEmpresaProdu(esAsigna);
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
		
		
		this.setActivaridTipoPrioridadEmpresaProdu(esInicial);
		this.setActivarid_empresaTipoPrioridadEmpresaProdu(esInicial);
		this.setActivarnombreTipoPrioridadEmpresaProdu(esInicial);
		this.setActivardescripcionTipoPrioridadEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.ID)) {
				this.setActivaridTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPrioridadEmpresaProdu(esInicial);
		this.setResaltarid_empresaTipoPrioridadEmpresaProdu(esInicial);
		this.setResaltarnombreTipoPrioridadEmpresaProdu(esInicial);
		this.setResaltardescripcionTipoPrioridadEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.ID)) {
				this.setResaltaridTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarOrdenProduTipoPrioridadEmpresaProdu=null;

	public Border getResaltarOrdenProduTipoPrioridadEmpresaProdu() {
		return this.resaltarOrdenProduTipoPrioridadEmpresaProdu;
	}

	public void setResaltarOrdenProduTipoPrioridadEmpresaProdu(Border borderResaltarOrdenProdu) {
		if(borderResaltarOrdenProdu!=null) {
			this.resaltarOrdenProduTipoPrioridadEmpresaProdu= borderResaltarOrdenProdu;
		}
	}

	public Border setResaltarOrdenProduTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarOrdenProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltarOrdenProdu);
			
		this.resaltarOrdenProduTipoPrioridadEmpresaProdu= borderResaltarOrdenProdu;

		 return borderResaltarOrdenProdu;
	}



	public Boolean mostrarOrdenProduTipoPrioridadEmpresaProdu=true;

	public Boolean getMostrarOrdenProduTipoPrioridadEmpresaProdu() {
		return this.mostrarOrdenProduTipoPrioridadEmpresaProdu;
	}

	public void setMostrarOrdenProduTipoPrioridadEmpresaProdu(Boolean visibilidadResaltarOrdenProdu) {
		this.mostrarOrdenProduTipoPrioridadEmpresaProdu= visibilidadResaltarOrdenProdu;
	}



	public Boolean activarOrdenProduTipoPrioridadEmpresaProdu=true;

	public Boolean gethabilitarResaltarOrdenProduTipoPrioridadEmpresaProdu() {
		return this.activarOrdenProduTipoPrioridadEmpresaProdu;
	}

	public void setActivarOrdenProduTipoPrioridadEmpresaProdu(Boolean habilitarResaltarOrdenProdu) {
		this.activarOrdenProduTipoPrioridadEmpresaProdu= habilitarResaltarOrdenProdu;
	}


	public Border resaltarPedidoProduTipoPrioridadEmpresaProdu=null;

	public Border getResaltarPedidoProduTipoPrioridadEmpresaProdu() {
		return this.resaltarPedidoProduTipoPrioridadEmpresaProdu;
	}

	public void setResaltarPedidoProduTipoPrioridadEmpresaProdu(Border borderResaltarPedidoProdu) {
		if(borderResaltarPedidoProdu!=null) {
			this.resaltarPedidoProduTipoPrioridadEmpresaProdu= borderResaltarPedidoProdu;
		}
	}

	public Border setResaltarPedidoProduTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprioridadempresaproduBeanSwingJInternalFrame.jTtoolBarTipoPrioridadEmpresaProdu.setBorder(borderResaltarPedidoProdu);
			
		this.resaltarPedidoProduTipoPrioridadEmpresaProdu= borderResaltarPedidoProdu;

		 return borderResaltarPedidoProdu;
	}



	public Boolean mostrarPedidoProduTipoPrioridadEmpresaProdu=true;

	public Boolean getMostrarPedidoProduTipoPrioridadEmpresaProdu() {
		return this.mostrarPedidoProduTipoPrioridadEmpresaProdu;
	}

	public void setMostrarPedidoProduTipoPrioridadEmpresaProdu(Boolean visibilidadResaltarPedidoProdu) {
		this.mostrarPedidoProduTipoPrioridadEmpresaProdu= visibilidadResaltarPedidoProdu;
	}



	public Boolean activarPedidoProduTipoPrioridadEmpresaProdu=true;

	public Boolean gethabilitarResaltarPedidoProduTipoPrioridadEmpresaProdu() {
		return this.activarPedidoProduTipoPrioridadEmpresaProdu;
	}

	public void setActivarPedidoProduTipoPrioridadEmpresaProdu(Boolean habilitarResaltarPedidoProdu) {
		this.activarPedidoProduTipoPrioridadEmpresaProdu= habilitarResaltarPedidoProdu;
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

		this.setMostrarOrdenProduTipoPrioridadEmpresaProdu(esInicial);
		this.setMostrarPedidoProduTipoPrioridadEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenProdu.class)) {
				this.setMostrarOrdenProduTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setMostrarPedidoProduTipoPrioridadEmpresaProdu(esAsigna);
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

		this.setActivarOrdenProduTipoPrioridadEmpresaProdu(esInicial);
		this.setActivarPedidoProduTipoPrioridadEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenProdu.class)) {
				this.setActivarOrdenProduTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setActivarPedidoProduTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarOrdenProduTipoPrioridadEmpresaProdu(esInicial);
		this.setResaltarPedidoProduTipoPrioridadEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenProdu.class)) {
				this.setResaltarOrdenProduTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setResaltarPedidoProduTipoPrioridadEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoPrioridadEmpresaProdu=true;

	public Boolean getMostrarFK_IdEmpresaTipoPrioridadEmpresaProdu() {
		return this.mostrarFK_IdEmpresaTipoPrioridadEmpresaProdu;
	}

	public void setMostrarFK_IdEmpresaTipoPrioridadEmpresaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPrioridadEmpresaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoPrioridadEmpresaProdu=true;

	public Boolean getActivarFK_IdEmpresaTipoPrioridadEmpresaProdu() {
		return this.activarFK_IdEmpresaTipoPrioridadEmpresaProdu;
	}

	public void setActivarFK_IdEmpresaTipoPrioridadEmpresaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPrioridadEmpresaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoPrioridadEmpresaProdu=null;

	public Border getResaltarFK_IdEmpresaTipoPrioridadEmpresaProdu() {
		return this.resaltarFK_IdEmpresaTipoPrioridadEmpresaProdu;
	}

	public void setResaltarFK_IdEmpresaTipoPrioridadEmpresaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPrioridadEmpresaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPrioridadEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadEmpresaProduBeanSwingJInternalFrame tipoprioridadempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPrioridadEmpresaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}