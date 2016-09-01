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


import com.bydan.erp.contabilidad.util.ParametroPlanillaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroPlanillaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroPlanillaParameterGeneral;

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
final public class ParametroPlanillaConstantesFunciones extends ParametroPlanillaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroPlanilla";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroPlanilla"+ParametroPlanillaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroPlanillaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroPlanillaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroPlanillaConstantesFunciones.SCHEMA+"_"+ParametroPlanillaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroPlanillaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroPlanillaConstantesFunciones.SCHEMA+"_"+ParametroPlanillaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroPlanillaConstantesFunciones.SCHEMA+"_"+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroPlanillaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroPlanillaConstantesFunciones.SCHEMA+"_"+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroPlanillaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroPlanillaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroPlanillaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroPlanillaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroPlanillaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroPlanillaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroPlanillaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Planillas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Planilla";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Planilla";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroPlanilla";
	public static final String OBJECTNAME="parametroplanilla";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_planilla";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroplanilla from "+ParametroPlanillaConstantesFunciones.SPERSISTENCENAME+" parametroplanilla";
	public static String QUERYSELECTNATIVE="select "+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME+".id,"+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME+".version_row,"+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME+".id_cuenta_contable_inicial,"+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME+".id_cuenta_contable_final from "+ParametroPlanillaConstantesFunciones.SCHEMA+"."+ParametroPlanillaConstantesFunciones.TABLENAME;//+" as "+ParametroPlanillaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroPlanillaConstantesFuncionesAdditional parametroplanillaConstantesFuncionesAdditional=null;
	
	public ParametroPlanillaConstantesFuncionesAdditional getParametroPlanillaConstantesFuncionesAdditional() {
		return this.parametroplanillaConstantesFuncionesAdditional;
	}
	
	public void setParametroPlanillaConstantesFuncionesAdditional(ParametroPlanillaConstantesFuncionesAdditional parametroplanillaConstantesFuncionesAdditional) {
		try {
			this.parametroplanillaConstantesFuncionesAdditional=parametroplanillaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLEINICIAL= "id_cuenta_contable_inicial";
    public static final String IDCUENTACONTABLEFINAL= "id_cuenta_contable_final";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLEINICIAL= "Cuenta C. Inicial";
		public static final String LABEL_IDCUENTACONTABLEINICIAL_LOWER= "Cuenta Contable Inicial";
    	public static final String LABEL_IDCUENTACONTABLEFINAL= "Cuenta C. Final";
		public static final String LABEL_IDCUENTACONTABLEFINAL_LOWER= "Cuenta Contable Final";
	
		
		
		
		
		
	
	public static String getParametroPlanillaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroPlanillaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroPlanillaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL)) {sLabelColumna=ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEINICIAL;}
		if(sNombreColumna.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL)) {sLabelColumna=ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEFINAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getParametroPlanillaDescripcion(ParametroPlanilla parametroplanilla) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroplanilla !=null/* && parametroplanilla.getId()!=0*/) {
			if(parametroplanilla.getId()!=null) {
				sDescripcion=parametroplanilla.getId().toString();
			}//parametroplanillaparametroplanilla.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroPlanillaDescripcionDetallado(ParametroPlanilla parametroplanilla) {
		String sDescripcion="";
			
		sDescripcion+=ParametroPlanillaConstantesFunciones.ID+"=";
		sDescripcion+=parametroplanilla.getId().toString()+",";
		sDescripcion+=ParametroPlanillaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroplanilla.getVersionRow().toString()+",";
		sDescripcion+=ParametroPlanillaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroplanilla.getid_empresa().toString()+",";
		sDescripcion+=ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL+"=";
		sDescripcion+=parametroplanilla.getid_cuenta_contable_inicial().toString()+",";
		sDescripcion+=ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL+"=";
		sDescripcion+=parametroplanilla.getid_cuenta_contable_final().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroPlanillaDescripcion(ParametroPlanilla parametroplanilla,String sValor) throws Exception {			
		if(parametroplanilla !=null) {
			//parametroplanillaparametroplanilla.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableInicialDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFinalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFinal")) {
			sNombreIndice="Tipo=  Por Cuenta C. Final";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInicial")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inicial";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableFinal(Long id_cuenta_contable_final) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_final!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Final="+id_cuenta_contable_final.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInicial(Long id_cuenta_contable_inicial) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inicial!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inicial="+id_cuenta_contable_inicial.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroPlanilla(ParametroPlanilla parametroplanilla,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroPlanillas(List<ParametroPlanilla> parametroplanillas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroPlanilla parametroplanilla: parametroplanillas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroPlanilla(ParametroPlanilla parametroplanilla,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroplanilla.getConCambioAuxiliar()) {
			parametroplanilla.setIsDeleted(parametroplanilla.getIsDeletedAuxiliar());	
			parametroplanilla.setIsNew(parametroplanilla.getIsNewAuxiliar());	
			parametroplanilla.setIsChanged(parametroplanilla.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroplanilla.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroplanilla.setIsDeletedAuxiliar(false);	
			parametroplanilla.setIsNewAuxiliar(false);	
			parametroplanilla.setIsChangedAuxiliar(false);
			
			parametroplanilla.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroPlanillas(List<ParametroPlanilla> parametroplanillas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroPlanilla parametroplanilla : parametroplanillas) {
			if(conAsignarBase && parametroplanilla.getConCambioAuxiliar()) {
				parametroplanilla.setIsDeleted(parametroplanilla.getIsDeletedAuxiliar());	
				parametroplanilla.setIsNew(parametroplanilla.getIsNewAuxiliar());	
				parametroplanilla.setIsChanged(parametroplanilla.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroplanilla.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroplanilla.setIsDeletedAuxiliar(false);	
				parametroplanilla.setIsNewAuxiliar(false);	
				parametroplanilla.setIsChangedAuxiliar(false);
				
				parametroplanilla.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroPlanilla(ParametroPlanilla parametroplanilla,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroPlanillas(List<ParametroPlanilla> parametroplanillas,Boolean conEnteros) throws Exception  {
		
		for(ParametroPlanilla parametroplanilla: parametroplanillas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroPlanilla(List<ParametroPlanilla> parametroplanillas,ParametroPlanilla parametroplanillaAux) throws Exception  {
		ParametroPlanillaConstantesFunciones.InicializarValoresParametroPlanilla(parametroplanillaAux,true);
		
		for(ParametroPlanilla parametroplanilla: parametroplanillas) {
			if(parametroplanilla.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroPlanilla(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroPlanillaConstantesFunciones.getArrayColumnasGlobalesParametroPlanilla(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroPlanilla(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroPlanillaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroPlanillaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroPlanilla(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroPlanilla> parametroplanillas,ParametroPlanilla parametroplanilla,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroPlanilla parametroplanillaAux: parametroplanillas) {
			if(parametroplanillaAux!=null && parametroplanilla!=null) {
				if((parametroplanillaAux.getId()==null && parametroplanilla.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroplanillaAux.getId()!=null && parametroplanilla.getId()!=null){
					if(parametroplanillaAux.getId().equals(parametroplanilla.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroPlanilla(List<ParametroPlanilla> parametroplanillas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroPlanilla parametroplanilla: parametroplanillas) {			
			if(parametroplanilla.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroPlanilla() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroPlanillaConstantesFunciones.LABEL_ID, ParametroPlanillaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroPlanillaConstantesFunciones.LABEL_VERSIONROW, ParametroPlanillaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroPlanillaConstantesFunciones.LABEL_IDEMPRESA, ParametroPlanillaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEINICIAL, ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEFINAL, ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroPlanilla() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroPlanillaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroPlanillaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroPlanillaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroPlanilla() throws Exception  {
		return ParametroPlanillaConstantesFunciones.getTiposSeleccionarParametroPlanilla(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroPlanilla(Boolean conFk) throws Exception  {
		return ParametroPlanillaConstantesFunciones.getTiposSeleccionarParametroPlanilla(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroPlanilla(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroPlanillaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroPlanillaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEINICIAL);
			reporte.setsDescripcion(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEFINAL);
			reporte.setsDescripcion(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroPlanilla(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroPlanilla(ParametroPlanilla parametroplanillaAux) throws Exception {
		
			parametroplanillaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroplanillaAux.getEmpresa()));
			parametroplanillaAux.setcuentacontableinicial_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroplanillaAux.getCuentaContableInicial()));
			parametroplanillaAux.setcuentacontablefinal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroplanillaAux.getCuentaContableFinal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroPlanilla(List<ParametroPlanilla> parametroplanillasTemp) throws Exception {
		for(ParametroPlanilla parametroplanillaAux:parametroplanillasTemp) {
			
			parametroplanillaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroplanillaAux.getEmpresa()));
			parametroplanillaAux.setcuentacontableinicial_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroplanillaAux.getCuentaContableInicial()));
			parametroplanillaAux.setcuentacontablefinal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroplanillaAux.getCuentaContableFinal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroPlanilla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroPlanilla(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroPlanilla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroPlanillaConstantesFunciones.getClassesRelationshipsOfParametroPlanilla(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroPlanilla(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroPlanilla(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroPlanillaConstantesFunciones.getClassesRelationshipsFromStringsOfParametroPlanilla(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroPlanilla(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroPlanilla parametroplanilla,List<ParametroPlanilla> parametroplanillas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroPlanilla parametroplanillaEncontrado=null;
			
			for(ParametroPlanilla parametroplanillaLocal:parametroplanillas) {
				if(parametroplanillaLocal.getId().equals(parametroplanilla.getId())) {
					parametroplanillaEncontrado=parametroplanillaLocal;
					
					parametroplanillaLocal.setIsChanged(parametroplanilla.getIsChanged());
					parametroplanillaLocal.setIsNew(parametroplanilla.getIsNew());
					parametroplanillaLocal.setIsDeleted(parametroplanilla.getIsDeleted());
					
					parametroplanillaLocal.setGeneralEntityOriginal(parametroplanilla.getGeneralEntityOriginal());
					
					parametroplanillaLocal.setId(parametroplanilla.getId());	
					parametroplanillaLocal.setVersionRow(parametroplanilla.getVersionRow());	
					parametroplanillaLocal.setid_empresa(parametroplanilla.getid_empresa());	
					parametroplanillaLocal.setid_cuenta_contable_inicial(parametroplanilla.getid_cuenta_contable_inicial());	
					parametroplanillaLocal.setid_cuenta_contable_final(parametroplanilla.getid_cuenta_contable_final());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroplanilla.getIsDeleted()) {
				if(!existe) {
					parametroplanillas.add(parametroplanilla);
				}
			} else {
				if(parametroplanillaEncontrado!=null && permiteQuitar)  {
					parametroplanillas.remove(parametroplanillaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroPlanilla parametroplanilla,List<ParametroPlanilla> parametroplanillas) throws Exception {
		try	{			
			for(ParametroPlanilla parametroplanillaLocal:parametroplanillas) {
				if(parametroplanillaLocal.getId().equals(parametroplanilla.getId())) {
					parametroplanillaLocal.setIsSelected(parametroplanilla.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroPlanilla(List<ParametroPlanilla> parametroplanillasAux) throws Exception {
		//this.parametroplanillasAux=parametroplanillasAux;
		
		for(ParametroPlanilla parametroplanillaAux:parametroplanillasAux) {
			if(parametroplanillaAux.getIsChanged()) {
				parametroplanillaAux.setIsChanged(false);
			}		
			
			if(parametroplanillaAux.getIsNew()) {
				parametroplanillaAux.setIsNew(false);
			}	
			
			if(parametroplanillaAux.getIsDeleted()) {
				parametroplanillaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroPlanilla(ParametroPlanilla parametroplanillaAux) throws Exception {
		//this.parametroplanillaAux=parametroplanillaAux;
		
			if(parametroplanillaAux.getIsChanged()) {
				parametroplanillaAux.setIsChanged(false);
			}		
			
			if(parametroplanillaAux.getIsNew()) {
				parametroplanillaAux.setIsNew(false);
			}	
			
			if(parametroplanillaAux.getIsDeleted()) {
				parametroplanillaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroPlanilla parametroplanillaAsignar,ParametroPlanilla parametroplanilla) throws Exception {
		parametroplanillaAsignar.setId(parametroplanilla.getId());	
		parametroplanillaAsignar.setVersionRow(parametroplanilla.getVersionRow());	
		parametroplanillaAsignar.setid_empresa(parametroplanilla.getid_empresa());
		parametroplanillaAsignar.setempresa_descripcion(parametroplanilla.getempresa_descripcion());	
		parametroplanillaAsignar.setid_cuenta_contable_inicial(parametroplanilla.getid_cuenta_contable_inicial());
		parametroplanillaAsignar.setcuentacontableinicial_descripcion(parametroplanilla.getcuentacontableinicial_descripcion());	
		parametroplanillaAsignar.setid_cuenta_contable_final(parametroplanilla.getid_cuenta_contable_final());
		parametroplanillaAsignar.setcuentacontablefinal_descripcion(parametroplanilla.getcuentacontablefinal_descripcion());	
	}
	
	public static void inicializarParametroPlanilla(ParametroPlanilla parametroplanilla) throws Exception {
		try {
				parametroplanilla.setId(0L);	
					
				parametroplanilla.setid_empresa(-1L);	
				parametroplanilla.setid_cuenta_contable_inicial(-1L);	
				parametroplanilla.setid_cuenta_contable_final(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroPlanilla(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroPlanillaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroPlanillaConstantesFunciones.LABEL_IDCUENTACONTABLEFINAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroPlanilla(String sTipo,Row row,Workbook workbook,ParametroPlanilla parametroplanilla,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroplanilla.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroplanilla.getcuentacontableinicial_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroplanilla.getcuentacontablefinal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroPlanilla=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroPlanilla() {
		return this.sFinalQueryParametroPlanilla;
	}
	
	public void setsFinalQueryParametroPlanilla(String sFinalQueryParametroPlanilla) {
		this.sFinalQueryParametroPlanilla= sFinalQueryParametroPlanilla;
	}
	
	public Border resaltarSeleccionarParametroPlanilla=null;
	
	public Border setResaltarSeleccionarParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroplanillaBeanSwingJInternalFrame.jTtoolBarParametroPlanilla.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroPlanilla= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroPlanilla() {
		return this.resaltarSeleccionarParametroPlanilla;
	}
	
	public void setResaltarSeleccionarParametroPlanilla(Border borderResaltarSeleccionarParametroPlanilla) {
		this.resaltarSeleccionarParametroPlanilla= borderResaltarSeleccionarParametroPlanilla;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroPlanilla=null;
	public Boolean mostraridParametroPlanilla=true;
	public Boolean activaridParametroPlanilla=true;

	public Border resaltarid_empresaParametroPlanilla=null;
	public Boolean mostrarid_empresaParametroPlanilla=true;
	public Boolean activarid_empresaParametroPlanilla=true;
	public Boolean cargarid_empresaParametroPlanilla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroPlanilla=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_inicialParametroPlanilla=null;
	public Boolean mostrarid_cuenta_contable_inicialParametroPlanilla=true;
	public Boolean activarid_cuenta_contable_inicialParametroPlanilla=true;
	public Boolean cargarid_cuenta_contable_inicialParametroPlanilla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inicialParametroPlanilla=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_finalParametroPlanilla=null;
	public Boolean mostrarid_cuenta_contable_finalParametroPlanilla=true;
	public Boolean activarid_cuenta_contable_finalParametroPlanilla=true;
	public Boolean cargarid_cuenta_contable_finalParametroPlanilla=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_finalParametroPlanilla=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroplanillaBeanSwingJInternalFrame.jTtoolBarParametroPlanilla.setBorder(borderResaltar);
		
		this.resaltaridParametroPlanilla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroPlanilla() {
		return this.resaltaridParametroPlanilla;
	}

	public void setResaltaridParametroPlanilla(Border borderResaltar) {
		this.resaltaridParametroPlanilla= borderResaltar;
	}

	public Boolean getMostraridParametroPlanilla() {
		return this.mostraridParametroPlanilla;
	}

	public void setMostraridParametroPlanilla(Boolean mostraridParametroPlanilla) {
		this.mostraridParametroPlanilla= mostraridParametroPlanilla;
	}

	public Boolean getActivaridParametroPlanilla() {
		return this.activaridParametroPlanilla;
	}

	public void setActivaridParametroPlanilla(Boolean activaridParametroPlanilla) {
		this.activaridParametroPlanilla= activaridParametroPlanilla;
	}

	public Border setResaltarid_empresaParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroplanillaBeanSwingJInternalFrame.jTtoolBarParametroPlanilla.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroPlanilla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroPlanilla() {
		return this.resaltarid_empresaParametroPlanilla;
	}

	public void setResaltarid_empresaParametroPlanilla(Border borderResaltar) {
		this.resaltarid_empresaParametroPlanilla= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroPlanilla() {
		return this.mostrarid_empresaParametroPlanilla;
	}

	public void setMostrarid_empresaParametroPlanilla(Boolean mostrarid_empresaParametroPlanilla) {
		this.mostrarid_empresaParametroPlanilla= mostrarid_empresaParametroPlanilla;
	}

	public Boolean getActivarid_empresaParametroPlanilla() {
		return this.activarid_empresaParametroPlanilla;
	}

	public void setActivarid_empresaParametroPlanilla(Boolean activarid_empresaParametroPlanilla) {
		this.activarid_empresaParametroPlanilla= activarid_empresaParametroPlanilla;
	}

	public Boolean getCargarid_empresaParametroPlanilla() {
		return this.cargarid_empresaParametroPlanilla;
	}

	public void setCargarid_empresaParametroPlanilla(Boolean cargarid_empresaParametroPlanilla) {
		this.cargarid_empresaParametroPlanilla= cargarid_empresaParametroPlanilla;
	}

	public Border setResaltarid_cuenta_contable_inicialParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroplanillaBeanSwingJInternalFrame.jTtoolBarParametroPlanilla.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inicialParametroPlanilla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inicialParametroPlanilla() {
		return this.resaltarid_cuenta_contable_inicialParametroPlanilla;
	}

	public void setResaltarid_cuenta_contable_inicialParametroPlanilla(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inicialParametroPlanilla= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inicialParametroPlanilla() {
		return this.mostrarid_cuenta_contable_inicialParametroPlanilla;
	}

	public void setMostrarid_cuenta_contable_inicialParametroPlanilla(Boolean mostrarid_cuenta_contable_inicialParametroPlanilla) {
		this.mostrarid_cuenta_contable_inicialParametroPlanilla= mostrarid_cuenta_contable_inicialParametroPlanilla;
	}

	public Boolean getActivarid_cuenta_contable_inicialParametroPlanilla() {
		return this.activarid_cuenta_contable_inicialParametroPlanilla;
	}

	public void setActivarid_cuenta_contable_inicialParametroPlanilla(Boolean activarid_cuenta_contable_inicialParametroPlanilla) {
		this.activarid_cuenta_contable_inicialParametroPlanilla= activarid_cuenta_contable_inicialParametroPlanilla;
	}

	public Boolean getCargarid_cuenta_contable_inicialParametroPlanilla() {
		return this.cargarid_cuenta_contable_inicialParametroPlanilla;
	}

	public void setCargarid_cuenta_contable_inicialParametroPlanilla(Boolean cargarid_cuenta_contable_inicialParametroPlanilla) {
		this.cargarid_cuenta_contable_inicialParametroPlanilla= cargarid_cuenta_contable_inicialParametroPlanilla;
	}

	public Border setResaltarid_cuenta_contable_finalParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroplanillaBeanSwingJInternalFrame.jTtoolBarParametroPlanilla.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_finalParametroPlanilla= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_finalParametroPlanilla() {
		return this.resaltarid_cuenta_contable_finalParametroPlanilla;
	}

	public void setResaltarid_cuenta_contable_finalParametroPlanilla(Border borderResaltar) {
		this.resaltarid_cuenta_contable_finalParametroPlanilla= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_finalParametroPlanilla() {
		return this.mostrarid_cuenta_contable_finalParametroPlanilla;
	}

	public void setMostrarid_cuenta_contable_finalParametroPlanilla(Boolean mostrarid_cuenta_contable_finalParametroPlanilla) {
		this.mostrarid_cuenta_contable_finalParametroPlanilla= mostrarid_cuenta_contable_finalParametroPlanilla;
	}

	public Boolean getActivarid_cuenta_contable_finalParametroPlanilla() {
		return this.activarid_cuenta_contable_finalParametroPlanilla;
	}

	public void setActivarid_cuenta_contable_finalParametroPlanilla(Boolean activarid_cuenta_contable_finalParametroPlanilla) {
		this.activarid_cuenta_contable_finalParametroPlanilla= activarid_cuenta_contable_finalParametroPlanilla;
	}

	public Boolean getCargarid_cuenta_contable_finalParametroPlanilla() {
		return this.cargarid_cuenta_contable_finalParametroPlanilla;
	}

	public void setCargarid_cuenta_contable_finalParametroPlanilla(Boolean cargarid_cuenta_contable_finalParametroPlanilla) {
		this.cargarid_cuenta_contable_finalParametroPlanilla= cargarid_cuenta_contable_finalParametroPlanilla;
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
		
		
		this.setMostraridParametroPlanilla(esInicial);
		this.setMostrarid_empresaParametroPlanilla(esInicial);
		this.setMostrarid_cuenta_contable_inicialParametroPlanilla(esInicial);
		this.setMostrarid_cuenta_contable_finalParametroPlanilla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.ID)) {
				this.setMostraridParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL)) {
				this.setMostrarid_cuenta_contable_inicialParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL)) {
				this.setMostrarid_cuenta_contable_finalParametroPlanilla(esAsigna);
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
		
		
		this.setActivaridParametroPlanilla(esInicial);
		this.setActivarid_empresaParametroPlanilla(esInicial);
		this.setActivarid_cuenta_contable_inicialParametroPlanilla(esInicial);
		this.setActivarid_cuenta_contable_finalParametroPlanilla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.ID)) {
				this.setActivaridParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL)) {
				this.setActivarid_cuenta_contable_inicialParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL)) {
				this.setActivarid_cuenta_contable_finalParametroPlanilla(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroPlanilla(esInicial);
		this.setResaltarid_empresaParametroPlanilla(esInicial);
		this.setResaltarid_cuenta_contable_inicialParametroPlanilla(esInicial);
		this.setResaltarid_cuenta_contable_finalParametroPlanilla(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.ID)) {
				this.setResaltaridParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL)) {
				this.setResaltarid_cuenta_contable_inicialParametroPlanilla(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL)) {
				this.setResaltarid_cuenta_contable_finalParametroPlanilla(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableFinalParametroPlanilla=true;

	public Boolean getMostrarFK_IdCuentaContableFinalParametroPlanilla() {
		return this.mostrarFK_IdCuentaContableFinalParametroPlanilla;
	}

	public void setMostrarFK_IdCuentaContableFinalParametroPlanilla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFinalParametroPlanilla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableInicialParametroPlanilla=true;

	public Boolean getMostrarFK_IdCuentaContableInicialParametroPlanilla() {
		return this.mostrarFK_IdCuentaContableInicialParametroPlanilla;
	}

	public void setMostrarFK_IdCuentaContableInicialParametroPlanilla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableInicialParametroPlanilla= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroPlanilla=true;

	public Boolean getMostrarFK_IdEmpresaParametroPlanilla() {
		return this.mostrarFK_IdEmpresaParametroPlanilla;
	}

	public void setMostrarFK_IdEmpresaParametroPlanilla(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroPlanilla= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableFinalParametroPlanilla=true;

	public Boolean getActivarFK_IdCuentaContableFinalParametroPlanilla() {
		return this.activarFK_IdCuentaContableFinalParametroPlanilla;
	}

	public void setActivarFK_IdCuentaContableFinalParametroPlanilla(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFinalParametroPlanilla= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableInicialParametroPlanilla=true;

	public Boolean getActivarFK_IdCuentaContableInicialParametroPlanilla() {
		return this.activarFK_IdCuentaContableInicialParametroPlanilla;
	}

	public void setActivarFK_IdCuentaContableInicialParametroPlanilla(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableInicialParametroPlanilla= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroPlanilla=true;

	public Boolean getActivarFK_IdEmpresaParametroPlanilla() {
		return this.activarFK_IdEmpresaParametroPlanilla;
	}

	public void setActivarFK_IdEmpresaParametroPlanilla(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroPlanilla= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableFinalParametroPlanilla=null;

	public Border getResaltarFK_IdCuentaContableFinalParametroPlanilla() {
		return this.resaltarFK_IdCuentaContableFinalParametroPlanilla;
	}

	public void setResaltarFK_IdCuentaContableFinalParametroPlanilla(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFinalParametroPlanilla= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFinalParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFinalParametroPlanilla= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableInicialParametroPlanilla=null;

	public Border getResaltarFK_IdCuentaContableInicialParametroPlanilla() {
		return this.resaltarFK_IdCuentaContableInicialParametroPlanilla;
	}

	public void setResaltarFK_IdCuentaContableInicialParametroPlanilla(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableInicialParametroPlanilla= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableInicialParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableInicialParametroPlanilla= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroPlanilla=null;

	public Border getResaltarFK_IdEmpresaParametroPlanilla() {
		return this.resaltarFK_IdEmpresaParametroPlanilla;
	}

	public void setResaltarFK_IdEmpresaParametroPlanilla(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroPlanilla= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroPlanilla(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroPlanillaBeanSwingJInternalFrame parametroplanillaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroPlanilla= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}