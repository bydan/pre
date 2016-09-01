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


import com.bydan.erp.nomina.util.ImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.ImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ImpuestoRentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ImpuestoRentaConstantesFunciones extends ImpuestoRentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ImpuestoRenta";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ImpuestoRenta"+ImpuestoRentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ImpuestoRentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ImpuestoRentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ImpuestoRentaConstantesFunciones.SCHEMA+"_"+ImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ImpuestoRentaConstantesFunciones.SCHEMA+"_"+ImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ImpuestoRentaConstantesFunciones.SCHEMA+"_"+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ImpuestoRentaConstantesFunciones.SCHEMA+"_"+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ImpuestoRentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ImpuestoRentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Impuesto Rentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Impuesto Renta";
	public static final String SCLASSWEBTITULO_LOWER="Impuesto Renta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ImpuestoRenta";
	public static final String OBJECTNAME="impuestorenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="impuesto_renta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select impuestorenta from "+ImpuestoRentaConstantesFunciones.SPERSISTENCENAME+" impuestorenta";
	public static String QUERYSELECTNATIVE="select "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".id,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".version_row,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".id_empresa,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".desde,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".hasta,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".impuesto,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".porcentaje from "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+ImpuestoRentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ImpuestoRentaConstantesFuncionesAdditional impuestorentaConstantesFuncionesAdditional=null;
	
	public ImpuestoRentaConstantesFuncionesAdditional getImpuestoRentaConstantesFuncionesAdditional() {
		return this.impuestorentaConstantesFuncionesAdditional;
	}
	
	public void setImpuestoRentaConstantesFuncionesAdditional(ImpuestoRentaConstantesFuncionesAdditional impuestorentaConstantesFuncionesAdditional) {
		try {
			this.impuestorentaConstantesFuncionesAdditional=impuestorentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String DESDE= "desde";
    public static final String HASTA= "hasta";
    public static final String IMPUESTO= "impuesto";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_DESDE= "Desde";
		public static final String LABEL_DESDE_LOWER= "Desde";
    	public static final String LABEL_HASTA= "Hasta";
		public static final String LABEL_HASTA_LOWER= "Hasta";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
	
	public static String getImpuestoRentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ImpuestoRentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ImpuestoRentaConstantesFunciones.DESDE)) {sLabelColumna=ImpuestoRentaConstantesFunciones.LABEL_DESDE;}
		if(sNombreColumna.equals(ImpuestoRentaConstantesFunciones.HASTA)) {sLabelColumna=ImpuestoRentaConstantesFunciones.LABEL_HASTA;}
		if(sNombreColumna.equals(ImpuestoRentaConstantesFunciones.IMPUESTO)) {sLabelColumna=ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(ImpuestoRentaConstantesFunciones.PORCENTAJE)) {sLabelColumna=ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getImpuestoRentaDescripcion(ImpuestoRenta impuestorenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(impuestorenta !=null/* && impuestorenta.getId()!=0*/) {
			if(impuestorenta.getId()!=null) {
				sDescripcion=impuestorenta.getId().toString();
			}//impuestorentaimpuestorenta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getImpuestoRentaDescripcionDetallado(ImpuestoRenta impuestorenta) {
		String sDescripcion="";
			
		sDescripcion+=ImpuestoRentaConstantesFunciones.ID+"=";
		sDescripcion+=impuestorenta.getId().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=impuestorenta.getVersionRow().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=impuestorenta.getid_empresa().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.DESDE+"=";
		sDescripcion+=impuestorenta.getdesde().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.HASTA+"=";
		sDescripcion+=impuestorenta.gethasta().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=impuestorenta.getimpuesto().toString()+",";
		sDescripcion+=ImpuestoRentaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=impuestorenta.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setImpuestoRentaDescripcion(ImpuestoRenta impuestorenta,String sValor) throws Exception {			
		if(impuestorenta !=null) {
			//impuestorentaimpuestorenta.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosImpuestoRenta(ImpuestoRenta impuestorenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosImpuestoRentas(List<ImpuestoRenta> impuestorentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ImpuestoRenta impuestorenta: impuestorentas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImpuestoRenta(ImpuestoRenta impuestorenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && impuestorenta.getConCambioAuxiliar()) {
			impuestorenta.setIsDeleted(impuestorenta.getIsDeletedAuxiliar());	
			impuestorenta.setIsNew(impuestorenta.getIsNewAuxiliar());	
			impuestorenta.setIsChanged(impuestorenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			impuestorenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			impuestorenta.setIsDeletedAuxiliar(false);	
			impuestorenta.setIsNewAuxiliar(false);	
			impuestorenta.setIsChangedAuxiliar(false);
			
			impuestorenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImpuestoRentas(List<ImpuestoRenta> impuestorentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ImpuestoRenta impuestorenta : impuestorentas) {
			if(conAsignarBase && impuestorenta.getConCambioAuxiliar()) {
				impuestorenta.setIsDeleted(impuestorenta.getIsDeletedAuxiliar());	
				impuestorenta.setIsNew(impuestorenta.getIsNewAuxiliar());	
				impuestorenta.setIsChanged(impuestorenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				impuestorenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				impuestorenta.setIsDeletedAuxiliar(false);	
				impuestorenta.setIsNewAuxiliar(false);	
				impuestorenta.setIsChangedAuxiliar(false);
				
				impuestorenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresImpuestoRenta(ImpuestoRenta impuestorenta,Boolean conEnteros) throws Exception  {
		impuestorenta.setdesde(0.0);
		impuestorenta.sethasta(0.0);
		impuestorenta.setimpuesto(0.0);
		impuestorenta.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresImpuestoRentas(List<ImpuestoRenta> impuestorentas,Boolean conEnteros) throws Exception  {
		
		for(ImpuestoRenta impuestorenta: impuestorentas) {
			impuestorenta.setdesde(0.0);
			impuestorenta.sethasta(0.0);
			impuestorenta.setimpuesto(0.0);
			impuestorenta.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaImpuestoRenta(List<ImpuestoRenta> impuestorentas,ImpuestoRenta impuestorentaAux) throws Exception  {
		ImpuestoRentaConstantesFunciones.InicializarValoresImpuestoRenta(impuestorentaAux,true);
		
		for(ImpuestoRenta impuestorenta: impuestorentas) {
			if(impuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			impuestorentaAux.setdesde(impuestorentaAux.getdesde()+impuestorenta.getdesde());			
			impuestorentaAux.sethasta(impuestorentaAux.gethasta()+impuestorenta.gethasta());			
			impuestorentaAux.setimpuesto(impuestorentaAux.getimpuesto()+impuestorenta.getimpuesto());			
			impuestorentaAux.setporcentaje(impuestorentaAux.getporcentaje()+impuestorenta.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ImpuestoRentaConstantesFunciones.getArrayColumnasGlobalesImpuestoRenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ImpuestoRentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ImpuestoRenta> impuestorentas,ImpuestoRenta impuestorenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ImpuestoRenta impuestorentaAux: impuestorentas) {
			if(impuestorentaAux!=null && impuestorenta!=null) {
				if((impuestorentaAux.getId()==null && impuestorenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(impuestorentaAux.getId()!=null && impuestorenta.getId()!=null){
					if(impuestorentaAux.getId().equals(impuestorenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaImpuestoRenta(List<ImpuestoRenta> impuestorentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double desdeTotal=0.0;
		Double hastaTotal=0.0;
		Double impuestoTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(ImpuestoRenta impuestorenta: impuestorentas) {			
			if(impuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			desdeTotal+=impuestorenta.getdesde();
			hastaTotal+=impuestorenta.gethasta();
			impuestoTotal+=impuestorenta.getimpuesto();
			porcentajeTotal+=impuestorenta.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImpuestoRentaConstantesFunciones.DESDE);
		datoGeneral.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_DESDE);
		datoGeneral.setdValorDouble(desdeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImpuestoRentaConstantesFunciones.HASTA);
		datoGeneral.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_HASTA);
		datoGeneral.setdValorDouble(hastaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImpuestoRentaConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImpuestoRentaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaImpuestoRenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_ID, ImpuestoRentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_VERSIONROW, ImpuestoRentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA, ImpuestoRentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_DESDE, ImpuestoRentaConstantesFunciones.DESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_HASTA, ImpuestoRentaConstantesFunciones.HASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO, ImpuestoRentaConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE, ImpuestoRentaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasImpuestoRenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.DESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.HASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoRentaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoRenta() throws Exception  {
		return ImpuestoRentaConstantesFunciones.getTiposSeleccionarImpuestoRenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoRenta(Boolean conFk) throws Exception  {
		return ImpuestoRentaConstantesFunciones.getTiposSeleccionarImpuestoRenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoRenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoRentaConstantesFunciones.LABEL_DESDE);
			reporte.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_DESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoRentaConstantesFunciones.LABEL_HASTA);
			reporte.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_HASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesImpuestoRenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesImpuestoRenta(ImpuestoRenta impuestorentaAux) throws Exception {
		
			impuestorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(impuestorentaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesImpuestoRenta(List<ImpuestoRenta> impuestorentasTemp) throws Exception {
		for(ImpuestoRenta impuestorentaAux:impuestorentasTemp) {
			
			impuestorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(impuestorentaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImpuestoRentaConstantesFunciones.getClassesRelationshipsOfImpuestoRenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImpuestoRentaConstantesFunciones.getClassesRelationshipsFromStringsOfImpuestoRenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ImpuestoRenta impuestorenta,List<ImpuestoRenta> impuestorentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ImpuestoRenta impuestorentaEncontrado=null;
			
			for(ImpuestoRenta impuestorentaLocal:impuestorentas) {
				if(impuestorentaLocal.getId().equals(impuestorenta.getId())) {
					impuestorentaEncontrado=impuestorentaLocal;
					
					impuestorentaLocal.setIsChanged(impuestorenta.getIsChanged());
					impuestorentaLocal.setIsNew(impuestorenta.getIsNew());
					impuestorentaLocal.setIsDeleted(impuestorenta.getIsDeleted());
					
					impuestorentaLocal.setGeneralEntityOriginal(impuestorenta.getGeneralEntityOriginal());
					
					impuestorentaLocal.setId(impuestorenta.getId());	
					impuestorentaLocal.setVersionRow(impuestorenta.getVersionRow());	
					impuestorentaLocal.setid_empresa(impuestorenta.getid_empresa());	
					impuestorentaLocal.setdesde(impuestorenta.getdesde());	
					impuestorentaLocal.sethasta(impuestorenta.gethasta());	
					impuestorentaLocal.setimpuesto(impuestorenta.getimpuesto());	
					impuestorentaLocal.setporcentaje(impuestorenta.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!impuestorenta.getIsDeleted()) {
				if(!existe) {
					impuestorentas.add(impuestorenta);
				}
			} else {
				if(impuestorentaEncontrado!=null && permiteQuitar)  {
					impuestorentas.remove(impuestorentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ImpuestoRenta impuestorenta,List<ImpuestoRenta> impuestorentas) throws Exception {
		try	{			
			for(ImpuestoRenta impuestorentaLocal:impuestorentas) {
				if(impuestorentaLocal.getId().equals(impuestorenta.getId())) {
					impuestorentaLocal.setIsSelected(impuestorenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesImpuestoRenta(List<ImpuestoRenta> impuestorentasAux) throws Exception {
		//this.impuestorentasAux=impuestorentasAux;
		
		for(ImpuestoRenta impuestorentaAux:impuestorentasAux) {
			if(impuestorentaAux.getIsChanged()) {
				impuestorentaAux.setIsChanged(false);
			}		
			
			if(impuestorentaAux.getIsNew()) {
				impuestorentaAux.setIsNew(false);
			}	
			
			if(impuestorentaAux.getIsDeleted()) {
				impuestorentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesImpuestoRenta(ImpuestoRenta impuestorentaAux) throws Exception {
		//this.impuestorentaAux=impuestorentaAux;
		
			if(impuestorentaAux.getIsChanged()) {
				impuestorentaAux.setIsChanged(false);
			}		
			
			if(impuestorentaAux.getIsNew()) {
				impuestorentaAux.setIsNew(false);
			}	
			
			if(impuestorentaAux.getIsDeleted()) {
				impuestorentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ImpuestoRenta impuestorentaAsignar,ImpuestoRenta impuestorenta) throws Exception {
		impuestorentaAsignar.setId(impuestorenta.getId());	
		impuestorentaAsignar.setVersionRow(impuestorenta.getVersionRow());	
		impuestorentaAsignar.setid_empresa(impuestorenta.getid_empresa());
		impuestorentaAsignar.setempresa_descripcion(impuestorenta.getempresa_descripcion());	
		impuestorentaAsignar.setdesde(impuestorenta.getdesde());	
		impuestorentaAsignar.sethasta(impuestorenta.gethasta());	
		impuestorentaAsignar.setimpuesto(impuestorenta.getimpuesto());	
		impuestorentaAsignar.setporcentaje(impuestorenta.getporcentaje());	
	}
	
	public static void inicializarImpuestoRenta(ImpuestoRenta impuestorenta) throws Exception {
		try {
				impuestorenta.setId(0L);	
					
				impuestorenta.setid_empresa(-1L);	
				impuestorenta.setdesde(0.0);	
				impuestorenta.sethasta(0.0);	
				impuestorenta.setimpuesto(0.0);	
				impuestorenta.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderImpuestoRenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoRentaConstantesFunciones.LABEL_DESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoRentaConstantesFunciones.LABEL_HASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoRentaConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoRentaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataImpuestoRenta(String sTipo,Row row,Workbook workbook,ImpuestoRenta impuestorenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestorenta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestorenta.getdesde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestorenta.gethasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestorenta.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestorenta.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryImpuestoRenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryImpuestoRenta() {
		return this.sFinalQueryImpuestoRenta;
	}
	
	public void setsFinalQueryImpuestoRenta(String sFinalQueryImpuestoRenta) {
		this.sFinalQueryImpuestoRenta= sFinalQueryImpuestoRenta;
	}
	
	public Border resaltarSeleccionarImpuestoRenta=null;
	
	public Border setResaltarSeleccionarImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarImpuestoRenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarImpuestoRenta() {
		return this.resaltarSeleccionarImpuestoRenta;
	}
	
	public void setResaltarSeleccionarImpuestoRenta(Border borderResaltarSeleccionarImpuestoRenta) {
		this.resaltarSeleccionarImpuestoRenta= borderResaltarSeleccionarImpuestoRenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridImpuestoRenta=null;
	public Boolean mostraridImpuestoRenta=true;
	public Boolean activaridImpuestoRenta=true;

	public Border resaltarid_empresaImpuestoRenta=null;
	public Boolean mostrarid_empresaImpuestoRenta=true;
	public Boolean activarid_empresaImpuestoRenta=true;
	public Boolean cargarid_empresaImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaImpuestoRenta=false;//ConEventDepend=true

	public Border resaltardesdeImpuestoRenta=null;
	public Boolean mostrardesdeImpuestoRenta=true;
	public Boolean activardesdeImpuestoRenta=true;

	public Border resaltarhastaImpuestoRenta=null;
	public Boolean mostrarhastaImpuestoRenta=true;
	public Boolean activarhastaImpuestoRenta=true;

	public Border resaltarimpuestoImpuestoRenta=null;
	public Boolean mostrarimpuestoImpuestoRenta=true;
	public Boolean activarimpuestoImpuestoRenta=true;

	public Border resaltarporcentajeImpuestoRenta=null;
	public Boolean mostrarporcentajeImpuestoRenta=true;
	public Boolean activarporcentajeImpuestoRenta=true;

	
	

	public Border setResaltaridImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltaridImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridImpuestoRenta() {
		return this.resaltaridImpuestoRenta;
	}

	public void setResaltaridImpuestoRenta(Border borderResaltar) {
		this.resaltaridImpuestoRenta= borderResaltar;
	}

	public Boolean getMostraridImpuestoRenta() {
		return this.mostraridImpuestoRenta;
	}

	public void setMostraridImpuestoRenta(Boolean mostraridImpuestoRenta) {
		this.mostraridImpuestoRenta= mostraridImpuestoRenta;
	}

	public Boolean getActivaridImpuestoRenta() {
		return this.activaridImpuestoRenta;
	}

	public void setActivaridImpuestoRenta(Boolean activaridImpuestoRenta) {
		this.activaridImpuestoRenta= activaridImpuestoRenta;
	}

	public Border setResaltarid_empresaImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaImpuestoRenta() {
		return this.resaltarid_empresaImpuestoRenta;
	}

	public void setResaltarid_empresaImpuestoRenta(Border borderResaltar) {
		this.resaltarid_empresaImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaImpuestoRenta() {
		return this.mostrarid_empresaImpuestoRenta;
	}

	public void setMostrarid_empresaImpuestoRenta(Boolean mostrarid_empresaImpuestoRenta) {
		this.mostrarid_empresaImpuestoRenta= mostrarid_empresaImpuestoRenta;
	}

	public Boolean getActivarid_empresaImpuestoRenta() {
		return this.activarid_empresaImpuestoRenta;
	}

	public void setActivarid_empresaImpuestoRenta(Boolean activarid_empresaImpuestoRenta) {
		this.activarid_empresaImpuestoRenta= activarid_empresaImpuestoRenta;
	}

	public Boolean getCargarid_empresaImpuestoRenta() {
		return this.cargarid_empresaImpuestoRenta;
	}

	public void setCargarid_empresaImpuestoRenta(Boolean cargarid_empresaImpuestoRenta) {
		this.cargarid_empresaImpuestoRenta= cargarid_empresaImpuestoRenta;
	}

	public Border setResaltardesdeImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltardesdeImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardesdeImpuestoRenta() {
		return this.resaltardesdeImpuestoRenta;
	}

	public void setResaltardesdeImpuestoRenta(Border borderResaltar) {
		this.resaltardesdeImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrardesdeImpuestoRenta() {
		return this.mostrardesdeImpuestoRenta;
	}

	public void setMostrardesdeImpuestoRenta(Boolean mostrardesdeImpuestoRenta) {
		this.mostrardesdeImpuestoRenta= mostrardesdeImpuestoRenta;
	}

	public Boolean getActivardesdeImpuestoRenta() {
		return this.activardesdeImpuestoRenta;
	}

	public void setActivardesdeImpuestoRenta(Boolean activardesdeImpuestoRenta) {
		this.activardesdeImpuestoRenta= activardesdeImpuestoRenta;
	}

	public Border setResaltarhastaImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarhastaImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhastaImpuestoRenta() {
		return this.resaltarhastaImpuestoRenta;
	}

	public void setResaltarhastaImpuestoRenta(Border borderResaltar) {
		this.resaltarhastaImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarhastaImpuestoRenta() {
		return this.mostrarhastaImpuestoRenta;
	}

	public void setMostrarhastaImpuestoRenta(Boolean mostrarhastaImpuestoRenta) {
		this.mostrarhastaImpuestoRenta= mostrarhastaImpuestoRenta;
	}

	public Boolean getActivarhastaImpuestoRenta() {
		return this.activarhastaImpuestoRenta;
	}

	public void setActivarhastaImpuestoRenta(Boolean activarhastaImpuestoRenta) {
		this.activarhastaImpuestoRenta= activarhastaImpuestoRenta;
	}

	public Border setResaltarimpuestoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarimpuestoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoImpuestoRenta() {
		return this.resaltarimpuestoImpuestoRenta;
	}

	public void setResaltarimpuestoImpuestoRenta(Border borderResaltar) {
		this.resaltarimpuestoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarimpuestoImpuestoRenta() {
		return this.mostrarimpuestoImpuestoRenta;
	}

	public void setMostrarimpuestoImpuestoRenta(Boolean mostrarimpuestoImpuestoRenta) {
		this.mostrarimpuestoImpuestoRenta= mostrarimpuestoImpuestoRenta;
	}

	public Boolean getActivarimpuestoImpuestoRenta() {
		return this.activarimpuestoImpuestoRenta;
	}

	public void setActivarimpuestoImpuestoRenta(Boolean activarimpuestoImpuestoRenta) {
		this.activarimpuestoImpuestoRenta= activarimpuestoImpuestoRenta;
	}

	public Border setResaltarporcentajeImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestorentaBeanSwingJInternalFrame.jTtoolBarImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarporcentajeImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeImpuestoRenta() {
		return this.resaltarporcentajeImpuestoRenta;
	}

	public void setResaltarporcentajeImpuestoRenta(Border borderResaltar) {
		this.resaltarporcentajeImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarporcentajeImpuestoRenta() {
		return this.mostrarporcentajeImpuestoRenta;
	}

	public void setMostrarporcentajeImpuestoRenta(Boolean mostrarporcentajeImpuestoRenta) {
		this.mostrarporcentajeImpuestoRenta= mostrarporcentajeImpuestoRenta;
	}

	public Boolean getActivarporcentajeImpuestoRenta() {
		return this.activarporcentajeImpuestoRenta;
	}

	public void setActivarporcentajeImpuestoRenta(Boolean activarporcentajeImpuestoRenta) {
		this.activarporcentajeImpuestoRenta= activarporcentajeImpuestoRenta;
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
		
		
		this.setMostraridImpuestoRenta(esInicial);
		this.setMostrarid_empresaImpuestoRenta(esInicial);
		this.setMostrardesdeImpuestoRenta(esInicial);
		this.setMostrarhastaImpuestoRenta(esInicial);
		this.setMostrarimpuestoImpuestoRenta(esInicial);
		this.setMostrarporcentajeImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.ID)) {
				this.setMostraridImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.DESDE)) {
				this.setMostrardesdeImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.HASTA)) {
				this.setMostrarhastaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeImpuestoRenta(esAsigna);
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
		
		
		this.setActivaridImpuestoRenta(esInicial);
		this.setActivarid_empresaImpuestoRenta(esInicial);
		this.setActivardesdeImpuestoRenta(esInicial);
		this.setActivarhastaImpuestoRenta(esInicial);
		this.setActivarimpuestoImpuestoRenta(esInicial);
		this.setActivarporcentajeImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.ID)) {
				this.setActivaridImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.DESDE)) {
				this.setActivardesdeImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.HASTA)) {
				this.setActivarhastaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeImpuestoRenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridImpuestoRenta(esInicial);
		this.setResaltarid_empresaImpuestoRenta(esInicial);
		this.setResaltardesdeImpuestoRenta(esInicial);
		this.setResaltarhastaImpuestoRenta(esInicial);
		this.setResaltarimpuestoImpuestoRenta(esInicial);
		this.setResaltarporcentajeImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.ID)) {
				this.setResaltaridImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.DESDE)) {
				this.setResaltardesdeImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.HASTA)) {
				this.setResaltarhastaImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoRentaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeImpuestoRenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaImpuestoRenta=true;

	public Boolean getMostrarFK_IdEmpresaImpuestoRenta() {
		return this.mostrarFK_IdEmpresaImpuestoRenta;
	}

	public void setMostrarFK_IdEmpresaImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaImpuestoRenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaImpuestoRenta=true;

	public Boolean getActivarFK_IdEmpresaImpuestoRenta() {
		return this.activarFK_IdEmpresaImpuestoRenta;
	}

	public void setActivarFK_IdEmpresaImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaImpuestoRenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaImpuestoRenta=null;

	public Border getResaltarFK_IdEmpresaImpuestoRenta() {
		return this.resaltarFK_IdEmpresaImpuestoRenta;
	}

	public void setResaltarFK_IdEmpresaImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoRentaBeanSwingJInternalFrame impuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaImpuestoRenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}