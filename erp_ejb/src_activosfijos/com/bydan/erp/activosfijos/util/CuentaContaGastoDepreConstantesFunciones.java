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


import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreConstantesFunciones;
import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaContaGastoDepreConstantesFunciones extends CuentaContaGastoDepreConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaContaGastoDepre";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaContaGastoDepre"+CuentaContaGastoDepreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaContaGastoDepreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaContaGastoDepreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaContaGastoDepreConstantesFunciones.SCHEMA+"_"+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContaGastoDepreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaContaGastoDepreConstantesFunciones.SCHEMA+"_"+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaContaGastoDepreConstantesFunciones.SCHEMA+"_"+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContaGastoDepreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaContaGastoDepreConstantesFunciones.SCHEMA+"_"+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContaGastoDepreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContaGastoDepreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaGastoDepreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaContaGastoDepreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaContaGastoDepreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaContaGastoDepreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaContaGastoDepreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Conta Gasto Depres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Conta Gasto Depre";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Conta Gasto Depre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaContaGastoDepre";
	public static final String OBJECTNAME="cuentacontagastodepre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="cuenta_conta_gasto_depre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentacontagastodepre from "+CuentaContaGastoDepreConstantesFunciones.SPERSISTENCENAME+" cuentacontagastodepre";
	public static String QUERYSELECTNATIVE="select "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".version_row,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id_gasto_depreciacion from "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME;//+" as "+CuentaContaGastoDepreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaContaGastoDepreConstantesFuncionesAdditional cuentacontagastodepreConstantesFuncionesAdditional=null;
	
	public CuentaContaGastoDepreConstantesFuncionesAdditional getCuentaContaGastoDepreConstantesFuncionesAdditional() {
		return this.cuentacontagastodepreConstantesFuncionesAdditional;
	}
	
	public void setCuentaContaGastoDepreConstantesFuncionesAdditional(CuentaContaGastoDepreConstantesFuncionesAdditional cuentacontagastodepreConstantesFuncionesAdditional) {
		try {
			this.cuentacontagastodepreConstantesFuncionesAdditional=cuentacontagastodepreConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDGASTODEPRECIACION= "id_gasto_depreciacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDGASTODEPRECIACION= "Gasto Depreciacion";
		public static final String LABEL_IDGASTODEPRECIACION_LOWER= "Gasto Depreciacion";
	
		
		
		
		
	
	public static String getCuentaContaGastoDepreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaContaGastoDepreConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION)) {sLabelColumna=CuentaContaGastoDepreConstantesFunciones.LABEL_IDGASTODEPRECIACION;}
		
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
	
	
	
			
			
			
			
	
	public static String getCuentaContaGastoDepreDescripcion(CuentaContaGastoDepre cuentacontagastodepre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentacontagastodepre !=null/* && cuentacontagastodepre.getId()!=0*/) {
			if(cuentacontagastodepre.getId()!=null) {
				sDescripcion=cuentacontagastodepre.getId().toString();
			}//cuentacontagastodeprecuentacontagastodepre.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaContaGastoDepreDescripcionDetallado(CuentaContaGastoDepre cuentacontagastodepre) {
		String sDescripcion="";
			
		sDescripcion+=CuentaContaGastoDepreConstantesFunciones.ID+"=";
		sDescripcion+=cuentacontagastodepre.getId().toString()+",";
		sDescripcion+=CuentaContaGastoDepreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentacontagastodepre.getVersionRow().toString()+",";
		sDescripcion+=CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentacontagastodepre.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION+"=";
		sDescripcion+=cuentacontagastodepre.getid_gasto_depreciacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaContaGastoDepreDescripcion(CuentaContaGastoDepre cuentacontagastodepre,String sValor) throws Exception {			
		if(cuentacontagastodepre !=null) {
			//cuentacontagastodeprecuentacontagastodepre.getId().toString();
		}		
	}
	
		

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getGastoDepreciacionDescripcion(GastoDepreciacion gastodepreciacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(gastodepreciacion!=null/*&&gastodepreciacion.getId()>0*/) {
			sDescripcion=GastoDepreciacionConstantesFunciones.getGastoDepreciacionDescripcion(gastodepreciacion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdGastoDepreciacion")) {
			sNombreIndice="Tipo=  Por Gasto Depreciacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGastoDepreciacion(Long id_gasto_depreciacion) {
		String sDetalleIndice=" Parametros->";
		if(id_gasto_depreciacion!=null) {sDetalleIndice+=" Codigo Unico De Gasto Depreciacion="+id_gasto_depreciacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCuentaContaGastoDepres(List<CuentaContaGastoDepre> cuentacontagastodepres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaContaGastoDepre cuentacontagastodepre: cuentacontagastodepres) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentacontagastodepre.getConCambioAuxiliar()) {
			cuentacontagastodepre.setIsDeleted(cuentacontagastodepre.getIsDeletedAuxiliar());	
			cuentacontagastodepre.setIsNew(cuentacontagastodepre.getIsNewAuxiliar());	
			cuentacontagastodepre.setIsChanged(cuentacontagastodepre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentacontagastodepre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentacontagastodepre.setIsDeletedAuxiliar(false);	
			cuentacontagastodepre.setIsNewAuxiliar(false);	
			cuentacontagastodepre.setIsChangedAuxiliar(false);
			
			cuentacontagastodepre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContaGastoDepres(List<CuentaContaGastoDepre> cuentacontagastodepres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaContaGastoDepre cuentacontagastodepre : cuentacontagastodepres) {
			if(conAsignarBase && cuentacontagastodepre.getConCambioAuxiliar()) {
				cuentacontagastodepre.setIsDeleted(cuentacontagastodepre.getIsDeletedAuxiliar());	
				cuentacontagastodepre.setIsNew(cuentacontagastodepre.getIsNewAuxiliar());	
				cuentacontagastodepre.setIsChanged(cuentacontagastodepre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentacontagastodepre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentacontagastodepre.setIsDeletedAuxiliar(false);	
				cuentacontagastodepre.setIsNewAuxiliar(false);	
				cuentacontagastodepre.setIsChangedAuxiliar(false);
				
				cuentacontagastodepre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaContaGastoDepres(List<CuentaContaGastoDepre> cuentacontagastodepres,Boolean conEnteros) throws Exception  {
		
		for(CuentaContaGastoDepre cuentacontagastodepre: cuentacontagastodepres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaContaGastoDepre(List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepre cuentacontagastodepreAux) throws Exception  {
		CuentaContaGastoDepreConstantesFunciones.InicializarValoresCuentaContaGastoDepre(cuentacontagastodepreAux,true);
		
		for(CuentaContaGastoDepre cuentacontagastodepre: cuentacontagastodepres) {
			if(cuentacontagastodepre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContaGastoDepre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaContaGastoDepreConstantesFunciones.getArrayColumnasGlobalesCuentaContaGastoDepre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContaGastoDepre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaContaGastoDepre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepre cuentacontagastodepre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaContaGastoDepre cuentacontagastodepreAux: cuentacontagastodepres) {
			if(cuentacontagastodepreAux!=null && cuentacontagastodepre!=null) {
				if((cuentacontagastodepreAux.getId()==null && cuentacontagastodepre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentacontagastodepreAux.getId()!=null && cuentacontagastodepre.getId()!=null){
					if(cuentacontagastodepreAux.getId().equals(cuentacontagastodepre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaContaGastoDepre(List<CuentaContaGastoDepre> cuentacontagastodepres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaContaGastoDepre cuentacontagastodepre: cuentacontagastodepres) {			
			if(cuentacontagastodepre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaContaGastoDepre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaContaGastoDepreConstantesFunciones.LABEL_ID, CuentaContaGastoDepreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaGastoDepreConstantesFunciones.LABEL_VERSIONROW, CuentaContaGastoDepreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaGastoDepreConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaGastoDepreConstantesFunciones.LABEL_IDGASTODEPRECIACION, CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaContaGastoDepre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaContaGastoDepreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaGastoDepreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaGastoDepre() throws Exception  {
		return CuentaContaGastoDepreConstantesFunciones.getTiposSeleccionarCuentaContaGastoDepre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaGastoDepre(Boolean conFk) throws Exception  {
		return CuentaContaGastoDepreConstantesFunciones.getTiposSeleccionarCuentaContaGastoDepre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaGastoDepre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContaGastoDepreConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaContaGastoDepreConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContaGastoDepreConstantesFunciones.LABEL_IDGASTODEPRECIACION);
			reporte.setsDescripcion(CuentaContaGastoDepreConstantesFunciones.LABEL_IDGASTODEPRECIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaContaGastoDepre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepreAux) throws Exception {
		
			cuentacontagastodepreAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontagastodepreAux.getCuentaContable()));
			cuentacontagastodepreAux.setgastodepreciacion_descripcion(GastoDepreciacionConstantesFunciones.getGastoDepreciacionDescripcion(cuentacontagastodepreAux.getGastoDepreciacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContaGastoDepre(List<CuentaContaGastoDepre> cuentacontagastodepresTemp) throws Exception {
		for(CuentaContaGastoDepre cuentacontagastodepreAux:cuentacontagastodepresTemp) {
			
			cuentacontagastodepreAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontagastodepreAux.getCuentaContable()));
			cuentacontagastodepreAux.setgastodepreciacion_descripcion(GastoDepreciacionConstantesFunciones.getGastoDepreciacionDescripcion(cuentacontagastodepreAux.getGastoDepreciacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContaGastoDepre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(GastoDepreciacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoDepreciacion.class)) {
						classes.add(new Classe(GastoDepreciacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaContaGastoDepre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(GastoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(GastoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaGastoDepre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContaGastoDepreConstantesFunciones.getClassesRelationshipsOfCuentaContaGastoDepre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaGastoDepre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContaGastoDepre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContaGastoDepreConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaContaGastoDepre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContaGastoDepre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentaContaGastoDepre cuentacontagastodepre,List<CuentaContaGastoDepre> cuentacontagastodepres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaContaGastoDepre cuentacontagastodepreEncontrado=null;
			
			for(CuentaContaGastoDepre cuentacontagastodepreLocal:cuentacontagastodepres) {
				if(cuentacontagastodepreLocal.getId().equals(cuentacontagastodepre.getId())) {
					cuentacontagastodepreEncontrado=cuentacontagastodepreLocal;
					
					cuentacontagastodepreLocal.setIsChanged(cuentacontagastodepre.getIsChanged());
					cuentacontagastodepreLocal.setIsNew(cuentacontagastodepre.getIsNew());
					cuentacontagastodepreLocal.setIsDeleted(cuentacontagastodepre.getIsDeleted());
					
					cuentacontagastodepreLocal.setGeneralEntityOriginal(cuentacontagastodepre.getGeneralEntityOriginal());
					
					cuentacontagastodepreLocal.setId(cuentacontagastodepre.getId());	
					cuentacontagastodepreLocal.setVersionRow(cuentacontagastodepre.getVersionRow());	
					cuentacontagastodepreLocal.setid_cuenta_contable(cuentacontagastodepre.getid_cuenta_contable());	
					cuentacontagastodepreLocal.setid_gasto_depreciacion(cuentacontagastodepre.getid_gasto_depreciacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentacontagastodepre.getIsDeleted()) {
				if(!existe) {
					cuentacontagastodepres.add(cuentacontagastodepre);
				}
			} else {
				if(cuentacontagastodepreEncontrado!=null && permiteQuitar)  {
					cuentacontagastodepres.remove(cuentacontagastodepreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaContaGastoDepre cuentacontagastodepre,List<CuentaContaGastoDepre> cuentacontagastodepres) throws Exception {
		try	{			
			for(CuentaContaGastoDepre cuentacontagastodepreLocal:cuentacontagastodepres) {
				if(cuentacontagastodepreLocal.getId().equals(cuentacontagastodepre.getId())) {
					cuentacontagastodepreLocal.setIsSelected(cuentacontagastodepre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaContaGastoDepre(List<CuentaContaGastoDepre> cuentacontagastodepresAux) throws Exception {
		//this.cuentacontagastodepresAux=cuentacontagastodepresAux;
		
		for(CuentaContaGastoDepre cuentacontagastodepreAux:cuentacontagastodepresAux) {
			if(cuentacontagastodepreAux.getIsChanged()) {
				cuentacontagastodepreAux.setIsChanged(false);
			}		
			
			if(cuentacontagastodepreAux.getIsNew()) {
				cuentacontagastodepreAux.setIsNew(false);
			}	
			
			if(cuentacontagastodepreAux.getIsDeleted()) {
				cuentacontagastodepreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepreAux) throws Exception {
		//this.cuentacontagastodepreAux=cuentacontagastodepreAux;
		
			if(cuentacontagastodepreAux.getIsChanged()) {
				cuentacontagastodepreAux.setIsChanged(false);
			}		
			
			if(cuentacontagastodepreAux.getIsNew()) {
				cuentacontagastodepreAux.setIsNew(false);
			}	
			
			if(cuentacontagastodepreAux.getIsDeleted()) {
				cuentacontagastodepreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaContaGastoDepre cuentacontagastodepreAsignar,CuentaContaGastoDepre cuentacontagastodepre) throws Exception {
		cuentacontagastodepreAsignar.setId(cuentacontagastodepre.getId());	
		cuentacontagastodepreAsignar.setVersionRow(cuentacontagastodepre.getVersionRow());	
		cuentacontagastodepreAsignar.setid_cuenta_contable(cuentacontagastodepre.getid_cuenta_contable());
		cuentacontagastodepreAsignar.setcuentacontable_descripcion(cuentacontagastodepre.getcuentacontable_descripcion());	
		cuentacontagastodepreAsignar.setid_gasto_depreciacion(cuentacontagastodepre.getid_gasto_depreciacion());
		cuentacontagastodepreAsignar.setgastodepreciacion_descripcion(cuentacontagastodepre.getgastodepreciacion_descripcion());	
	}
	
	public static void inicializarCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre) throws Exception {
		try {
				cuentacontagastodepre.setId(0L);	
					
				cuentacontagastodepre.setid_cuenta_contable(-1L);	
				cuentacontagastodepre.setid_gasto_depreciacion(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaContaGastoDepre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContaGastoDepreConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContaGastoDepreConstantesFunciones.LABEL_IDGASTODEPRECIACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaContaGastoDepre(String sTipo,Row row,Workbook workbook,CuentaContaGastoDepre cuentacontagastodepre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontagastodepre.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontagastodepre.getgastodepreciacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaContaGastoDepre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaContaGastoDepre() {
		return this.sFinalQueryCuentaContaGastoDepre;
	}
	
	public void setsFinalQueryCuentaContaGastoDepre(String sFinalQueryCuentaContaGastoDepre) {
		this.sFinalQueryCuentaContaGastoDepre= sFinalQueryCuentaContaGastoDepre;
	}
	
	public Border resaltarSeleccionarCuentaContaGastoDepre=null;
	
	public Border setResaltarSeleccionarCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentacontagastodepreBeanSwingJInternalFrame.jTtoolBarCuentaContaGastoDepre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaContaGastoDepre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaContaGastoDepre() {
		return this.resaltarSeleccionarCuentaContaGastoDepre;
	}
	
	public void setResaltarSeleccionarCuentaContaGastoDepre(Border borderResaltarSeleccionarCuentaContaGastoDepre) {
		this.resaltarSeleccionarCuentaContaGastoDepre= borderResaltarSeleccionarCuentaContaGastoDepre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaContaGastoDepre=null;
	public Boolean mostraridCuentaContaGastoDepre=true;
	public Boolean activaridCuentaContaGastoDepre=true;

	public Border resaltarid_cuenta_contableCuentaContaGastoDepre=null;
	public Boolean mostrarid_cuenta_contableCuentaContaGastoDepre=true;
	public Boolean activarid_cuenta_contableCuentaContaGastoDepre=true;
	public Boolean cargarid_cuenta_contableCuentaContaGastoDepre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaContaGastoDepre=false;//ConEventDepend=true

	public Border resaltarid_gasto_depreciacionCuentaContaGastoDepre=null;
	public Boolean mostrarid_gasto_depreciacionCuentaContaGastoDepre=true;
	public Boolean activarid_gasto_depreciacionCuentaContaGastoDepre=true;
	public Boolean cargarid_gasto_depreciacionCuentaContaGastoDepre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_gasto_depreciacionCuentaContaGastoDepre=false;//ConEventDepend=true

	
	

	public Border setResaltaridCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontagastodepreBeanSwingJInternalFrame.jTtoolBarCuentaContaGastoDepre.setBorder(borderResaltar);
		
		this.resaltaridCuentaContaGastoDepre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaContaGastoDepre() {
		return this.resaltaridCuentaContaGastoDepre;
	}

	public void setResaltaridCuentaContaGastoDepre(Border borderResaltar) {
		this.resaltaridCuentaContaGastoDepre= borderResaltar;
	}

	public Boolean getMostraridCuentaContaGastoDepre() {
		return this.mostraridCuentaContaGastoDepre;
	}

	public void setMostraridCuentaContaGastoDepre(Boolean mostraridCuentaContaGastoDepre) {
		this.mostraridCuentaContaGastoDepre= mostraridCuentaContaGastoDepre;
	}

	public Boolean getActivaridCuentaContaGastoDepre() {
		return this.activaridCuentaContaGastoDepre;
	}

	public void setActivaridCuentaContaGastoDepre(Boolean activaridCuentaContaGastoDepre) {
		this.activaridCuentaContaGastoDepre= activaridCuentaContaGastoDepre;
	}

	public Border setResaltarid_cuenta_contableCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontagastodepreBeanSwingJInternalFrame.jTtoolBarCuentaContaGastoDepre.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaContaGastoDepre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaContaGastoDepre() {
		return this.resaltarid_cuenta_contableCuentaContaGastoDepre;
	}

	public void setResaltarid_cuenta_contableCuentaContaGastoDepre(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaContaGastoDepre= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaContaGastoDepre() {
		return this.mostrarid_cuenta_contableCuentaContaGastoDepre;
	}

	public void setMostrarid_cuenta_contableCuentaContaGastoDepre(Boolean mostrarid_cuenta_contableCuentaContaGastoDepre) {
		this.mostrarid_cuenta_contableCuentaContaGastoDepre= mostrarid_cuenta_contableCuentaContaGastoDepre;
	}

	public Boolean getActivarid_cuenta_contableCuentaContaGastoDepre() {
		return this.activarid_cuenta_contableCuentaContaGastoDepre;
	}

	public void setActivarid_cuenta_contableCuentaContaGastoDepre(Boolean activarid_cuenta_contableCuentaContaGastoDepre) {
		this.activarid_cuenta_contableCuentaContaGastoDepre= activarid_cuenta_contableCuentaContaGastoDepre;
	}

	public Boolean getCargarid_cuenta_contableCuentaContaGastoDepre() {
		return this.cargarid_cuenta_contableCuentaContaGastoDepre;
	}

	public void setCargarid_cuenta_contableCuentaContaGastoDepre(Boolean cargarid_cuenta_contableCuentaContaGastoDepre) {
		this.cargarid_cuenta_contableCuentaContaGastoDepre= cargarid_cuenta_contableCuentaContaGastoDepre;
	}

	public Border setResaltarid_gasto_depreciacionCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontagastodepreBeanSwingJInternalFrame.jTtoolBarCuentaContaGastoDepre.setBorder(borderResaltar);
		
		this.resaltarid_gasto_depreciacionCuentaContaGastoDepre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_gasto_depreciacionCuentaContaGastoDepre() {
		return this.resaltarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public void setResaltarid_gasto_depreciacionCuentaContaGastoDepre(Border borderResaltar) {
		this.resaltarid_gasto_depreciacionCuentaContaGastoDepre= borderResaltar;
	}

	public Boolean getMostrarid_gasto_depreciacionCuentaContaGastoDepre() {
		return this.mostrarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public void setMostrarid_gasto_depreciacionCuentaContaGastoDepre(Boolean mostrarid_gasto_depreciacionCuentaContaGastoDepre) {
		this.mostrarid_gasto_depreciacionCuentaContaGastoDepre= mostrarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public Boolean getActivarid_gasto_depreciacionCuentaContaGastoDepre() {
		return this.activarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public void setActivarid_gasto_depreciacionCuentaContaGastoDepre(Boolean activarid_gasto_depreciacionCuentaContaGastoDepre) {
		this.activarid_gasto_depreciacionCuentaContaGastoDepre= activarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public Boolean getCargarid_gasto_depreciacionCuentaContaGastoDepre() {
		return this.cargarid_gasto_depreciacionCuentaContaGastoDepre;
	}

	public void setCargarid_gasto_depreciacionCuentaContaGastoDepre(Boolean cargarid_gasto_depreciacionCuentaContaGastoDepre) {
		this.cargarid_gasto_depreciacionCuentaContaGastoDepre= cargarid_gasto_depreciacionCuentaContaGastoDepre;
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
		
		
		this.setMostraridCuentaContaGastoDepre(esInicial);
		this.setMostrarid_cuenta_contableCuentaContaGastoDepre(esInicial);
		this.setMostrarid_gasto_depreciacionCuentaContaGastoDepre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.ID)) {
				this.setMostraridCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION)) {
				this.setMostrarid_gasto_depreciacionCuentaContaGastoDepre(esAsigna);
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
		
		
		this.setActivaridCuentaContaGastoDepre(esInicial);
		this.setActivarid_cuenta_contableCuentaContaGastoDepre(esInicial);
		this.setActivarid_gasto_depreciacionCuentaContaGastoDepre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.ID)) {
				this.setActivaridCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION)) {
				this.setActivarid_gasto_depreciacionCuentaContaGastoDepre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaContaGastoDepre(esInicial);
		this.setResaltarid_cuenta_contableCuentaContaGastoDepre(esInicial);
		this.setResaltarid_gasto_depreciacionCuentaContaGastoDepre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.ID)) {
				this.setResaltaridCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaContaGastoDepre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION)) {
				this.setResaltarid_gasto_depreciacionCuentaContaGastoDepre(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableCuentaContaGastoDepre=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaContaGastoDepre() {
		return this.mostrarFK_IdCuentaContableCuentaContaGastoDepre;
	}

	public void setMostrarFK_IdCuentaContableCuentaContaGastoDepre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaContaGastoDepre= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGastoDepreciacionCuentaContaGastoDepre=true;

	public Boolean getMostrarFK_IdGastoDepreciacionCuentaContaGastoDepre() {
		return this.mostrarFK_IdGastoDepreciacionCuentaContaGastoDepre;
	}

	public void setMostrarFK_IdGastoDepreciacionCuentaContaGastoDepre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGastoDepreciacionCuentaContaGastoDepre= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableCuentaContaGastoDepre=true;

	public Boolean getActivarFK_IdCuentaContableCuentaContaGastoDepre() {
		return this.activarFK_IdCuentaContableCuentaContaGastoDepre;
	}

	public void setActivarFK_IdCuentaContableCuentaContaGastoDepre(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaContaGastoDepre= habilitarResaltar;
	}

	public Boolean activarFK_IdGastoDepreciacionCuentaContaGastoDepre=true;

	public Boolean getActivarFK_IdGastoDepreciacionCuentaContaGastoDepre() {
		return this.activarFK_IdGastoDepreciacionCuentaContaGastoDepre;
	}

	public void setActivarFK_IdGastoDepreciacionCuentaContaGastoDepre(Boolean habilitarResaltar) {
		this.activarFK_IdGastoDepreciacionCuentaContaGastoDepre= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableCuentaContaGastoDepre=null;

	public Border getResaltarFK_IdCuentaContableCuentaContaGastoDepre() {
		return this.resaltarFK_IdCuentaContableCuentaContaGastoDepre;
	}

	public void setResaltarFK_IdCuentaContableCuentaContaGastoDepre(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaContaGastoDepre= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaContaGastoDepre= borderResaltar;
	}

	public Border resaltarFK_IdGastoDepreciacionCuentaContaGastoDepre=null;

	public Border getResaltarFK_IdGastoDepreciacionCuentaContaGastoDepre() {
		return this.resaltarFK_IdGastoDepreciacionCuentaContaGastoDepre;
	}

	public void setResaltarFK_IdGastoDepreciacionCuentaContaGastoDepre(Border borderResaltar) {
		this.resaltarFK_IdGastoDepreciacionCuentaContaGastoDepre= borderResaltar;
	}

	public void setResaltarFK_IdGastoDepreciacionCuentaContaGastoDepre(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaGastoDepreBeanSwingJInternalFrame cuentacontagastodepreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGastoDepreciacionCuentaContaGastoDepre= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}