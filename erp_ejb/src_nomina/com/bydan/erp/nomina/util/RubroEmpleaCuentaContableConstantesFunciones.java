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


import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RubroEmpleaCuentaContableConstantesFunciones extends RubroEmpleaCuentaContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RubroEmpleaCuentaContable";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RubroEmpleaCuentaContable"+RubroEmpleaCuentaContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RubroEmpleaCuentaContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RubroEmpleaCuentaContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"_"+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleaCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"_"+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"_"+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleaCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"_"+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleaCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleaCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RubroEmpleaCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RubroEmpleaCuentaContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RubroEmpleaCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RubroEmpleaCuentaContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rubro Emplea Cuenta Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rubro Emplea Cuenta Contable";
	public static final String SCLASSWEBTITULO_LOWER="Rubro Emplea Cuenta Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RubroEmpleaCuentaContable";
	public static final String OBJECTNAME="rubroempleacuentacontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rubro_emplea_cuenta_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rubroempleacuentacontable from "+RubroEmpleaCuentaContableConstantesFunciones.SPERSISTENCENAME+" rubroempleacuentacontable";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_sucursal,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_estructura from "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RubroEmpleaCuentaContableConstantesFuncionesAdditional rubroempleacuentacontableConstantesFuncionesAdditional=null;
	
	public RubroEmpleaCuentaContableConstantesFuncionesAdditional getRubroEmpleaCuentaContableConstantesFuncionesAdditional() {
		return this.rubroempleacuentacontableConstantesFuncionesAdditional;
	}
	
	public void setRubroEmpleaCuentaContableConstantesFuncionesAdditional(RubroEmpleaCuentaContableConstantesFuncionesAdditional rubroempleacuentacontableConstantesFuncionesAdditional) {
		try {
			this.rubroempleacuentacontableConstantesFuncionesAdditional=rubroempleacuentacontableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDESTRUCTURA= "id_estructura";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
	
		
		
		
		
		
		
		
	
	public static String getRubroEmpleaCuentaContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDESTRUCTURA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getRubroEmpleaCuentaContableDescripcion(RubroEmpleaCuentaContable rubroempleacuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rubroempleacuentacontable !=null/* && rubroempleacuentacontable.getId()!=0*/) {
			if(rubroempleacuentacontable.getId()!=null) {
				sDescripcion=rubroempleacuentacontable.getId().toString();
			}//rubroempleacuentacontablerubroempleacuentacontable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRubroEmpleaCuentaContableDescripcionDetallado(RubroEmpleaCuentaContable rubroempleacuentacontable) {
		String sDescripcion="";
			
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.ID+"=";
		sDescripcion+=rubroempleacuentacontable.getId().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rubroempleacuentacontable.getVersionRow().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rubroempleacuentacontable.getid_empresa().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=rubroempleacuentacontable.getid_sucursal().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=rubroempleacuentacontable.getid_rubro_emplea().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=rubroempleacuentacontable.getid_cuenta_contable().toString()+",";
		sDescripcion+=RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=rubroempleacuentacontable.getid_estructura().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRubroEmpleaCuentaContableDescripcion(RubroEmpleaCuentaContable rubroempleacuentacontable,String sValor) throws Exception {			
		if(rubroempleacuentacontable !=null) {
			//rubroempleacuentacontablerubroempleacuentacontable.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable: rubroempleacuentacontables) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rubroempleacuentacontable.getConCambioAuxiliar()) {
			rubroempleacuentacontable.setIsDeleted(rubroempleacuentacontable.getIsDeletedAuxiliar());	
			rubroempleacuentacontable.setIsNew(rubroempleacuentacontable.getIsNewAuxiliar());	
			rubroempleacuentacontable.setIsChanged(rubroempleacuentacontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rubroempleacuentacontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rubroempleacuentacontable.setIsDeletedAuxiliar(false);	
			rubroempleacuentacontable.setIsNewAuxiliar(false);	
			rubroempleacuentacontable.setIsChangedAuxiliar(false);
			
			rubroempleacuentacontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable : rubroempleacuentacontables) {
			if(conAsignarBase && rubroempleacuentacontable.getConCambioAuxiliar()) {
				rubroempleacuentacontable.setIsDeleted(rubroempleacuentacontable.getIsDeletedAuxiliar());	
				rubroempleacuentacontable.setIsNew(rubroempleacuentacontable.getIsNewAuxiliar());	
				rubroempleacuentacontable.setIsChanged(rubroempleacuentacontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rubroempleacuentacontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rubroempleacuentacontable.setIsDeletedAuxiliar(false);	
				rubroempleacuentacontable.setIsNewAuxiliar(false);	
				rubroempleacuentacontable.setIsChangedAuxiliar(false);
				
				rubroempleacuentacontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables,Boolean conEnteros) throws Exception  {
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable: rubroempleacuentacontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContable rubroempleacuentacontableAux) throws Exception  {
		RubroEmpleaCuentaContableConstantesFunciones.InicializarValoresRubroEmpleaCuentaContable(rubroempleacuentacontableAux,true);
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable: rubroempleacuentacontables) {
			if(rubroempleacuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmpleaCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RubroEmpleaCuentaContableConstantesFunciones.getArrayColumnasGlobalesRubroEmpleaCuentaContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmpleaCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRubroEmpleaCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontableAux: rubroempleacuentacontables) {
			if(rubroempleacuentacontableAux!=null && rubroempleacuentacontable!=null) {
				if((rubroempleacuentacontableAux.getId()==null && rubroempleacuentacontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rubroempleacuentacontableAux.getId()!=null && rubroempleacuentacontable.getId()!=null){
					if(rubroempleacuentacontableAux.getId().equals(rubroempleacuentacontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> rubroempleacuentacontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RubroEmpleaCuentaContable rubroempleacuentacontable: rubroempleacuentacontables) {			
			if(rubroempleacuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRubroEmpleaCuentaContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_ID, RubroEmpleaCuentaContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_VERSIONROW, RubroEmpleaCuentaContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDEMPRESA, RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDSUCURSAL, RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDRUBROEMPLEA, RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE, RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDESTRUCTURA, RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRubroEmpleaCuentaContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleaCuentaContable() throws Exception  {
		return RubroEmpleaCuentaContableConstantesFunciones.getTiposSeleccionarRubroEmpleaCuentaContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleaCuentaContable(Boolean conFk) throws Exception  {
		return RubroEmpleaCuentaContableConstantesFunciones.getTiposSeleccionarRubroEmpleaCuentaContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleaCuentaContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRubroEmpleaCuentaContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontableAux) throws Exception {
		
			rubroempleacuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleacuentacontableAux.getEmpresa()));
			rubroempleacuentacontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(rubroempleacuentacontableAux.getSucursal()));
			rubroempleacuentacontableAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroempleacuentacontableAux.getRubroEmplea()));
			rubroempleacuentacontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(rubroempleacuentacontableAux.getCuentaContable()));
			rubroempleacuentacontableAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(rubroempleacuentacontableAux.getEstructura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> rubroempleacuentacontablesTemp) throws Exception {
		for(RubroEmpleaCuentaContable rubroempleacuentacontableAux:rubroempleacuentacontablesTemp) {
			
			rubroempleacuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleacuentacontableAux.getEmpresa()));
			rubroempleacuentacontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(rubroempleacuentacontableAux.getSucursal()));
			rubroempleacuentacontableAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroempleacuentacontableAux.getRubroEmplea()));
			rubroempleacuentacontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(rubroempleacuentacontableAux.getCuentaContable()));
			rubroempleacuentacontableAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(rubroempleacuentacontableAux.getEstructura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmpleaCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Estructura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRubroEmpleaCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleaCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleaCuentaContableConstantesFunciones.getClassesRelationshipsOfRubroEmpleaCuentaContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleaCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmpleaCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleaCuentaContableConstantesFunciones.getClassesRelationshipsFromStringsOfRubroEmpleaCuentaContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmpleaCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RubroEmpleaCuentaContable rubroempleacuentacontable,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RubroEmpleaCuentaContable rubroempleacuentacontableEncontrado=null;
			
			for(RubroEmpleaCuentaContable rubroempleacuentacontableLocal:rubroempleacuentacontables) {
				if(rubroempleacuentacontableLocal.getId().equals(rubroempleacuentacontable.getId())) {
					rubroempleacuentacontableEncontrado=rubroempleacuentacontableLocal;
					
					rubroempleacuentacontableLocal.setIsChanged(rubroempleacuentacontable.getIsChanged());
					rubroempleacuentacontableLocal.setIsNew(rubroempleacuentacontable.getIsNew());
					rubroempleacuentacontableLocal.setIsDeleted(rubroempleacuentacontable.getIsDeleted());
					
					rubroempleacuentacontableLocal.setGeneralEntityOriginal(rubroempleacuentacontable.getGeneralEntityOriginal());
					
					rubroempleacuentacontableLocal.setId(rubroempleacuentacontable.getId());	
					rubroempleacuentacontableLocal.setVersionRow(rubroempleacuentacontable.getVersionRow());	
					rubroempleacuentacontableLocal.setid_empresa(rubroempleacuentacontable.getid_empresa());	
					rubroempleacuentacontableLocal.setid_sucursal(rubroempleacuentacontable.getid_sucursal());	
					rubroempleacuentacontableLocal.setid_rubro_emplea(rubroempleacuentacontable.getid_rubro_emplea());	
					rubroempleacuentacontableLocal.setid_cuenta_contable(rubroempleacuentacontable.getid_cuenta_contable());	
					rubroempleacuentacontableLocal.setid_estructura(rubroempleacuentacontable.getid_estructura());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!rubroempleacuentacontable.getIsDeleted()) {
				if(!existe) {
					rubroempleacuentacontables.add(rubroempleacuentacontable);
				}
			} else {
				if(rubroempleacuentacontableEncontrado!=null && permiteQuitar)  {
					rubroempleacuentacontables.remove(rubroempleacuentacontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RubroEmpleaCuentaContable rubroempleacuentacontable,List<RubroEmpleaCuentaContable> rubroempleacuentacontables) throws Exception {
		try	{			
			for(RubroEmpleaCuentaContable rubroempleacuentacontableLocal:rubroempleacuentacontables) {
				if(rubroempleacuentacontableLocal.getId().equals(rubroempleacuentacontable.getId())) {
					rubroempleacuentacontableLocal.setIsSelected(rubroempleacuentacontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> rubroempleacuentacontablesAux) throws Exception {
		//this.rubroempleacuentacontablesAux=rubroempleacuentacontablesAux;
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontableAux:rubroempleacuentacontablesAux) {
			if(rubroempleacuentacontableAux.getIsChanged()) {
				rubroempleacuentacontableAux.setIsChanged(false);
			}		
			
			if(rubroempleacuentacontableAux.getIsNew()) {
				rubroempleacuentacontableAux.setIsNew(false);
			}	
			
			if(rubroempleacuentacontableAux.getIsDeleted()) {
				rubroempleacuentacontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontableAux) throws Exception {
		//this.rubroempleacuentacontableAux=rubroempleacuentacontableAux;
		
			if(rubroempleacuentacontableAux.getIsChanged()) {
				rubroempleacuentacontableAux.setIsChanged(false);
			}		
			
			if(rubroempleacuentacontableAux.getIsNew()) {
				rubroempleacuentacontableAux.setIsNew(false);
			}	
			
			if(rubroempleacuentacontableAux.getIsDeleted()) {
				rubroempleacuentacontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RubroEmpleaCuentaContable rubroempleacuentacontableAsignar,RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {
		rubroempleacuentacontableAsignar.setId(rubroempleacuentacontable.getId());	
		rubroempleacuentacontableAsignar.setVersionRow(rubroempleacuentacontable.getVersionRow());	
		rubroempleacuentacontableAsignar.setid_empresa(rubroempleacuentacontable.getid_empresa());
		rubroempleacuentacontableAsignar.setempresa_descripcion(rubroempleacuentacontable.getempresa_descripcion());	
		rubroempleacuentacontableAsignar.setid_sucursal(rubroempleacuentacontable.getid_sucursal());
		rubroempleacuentacontableAsignar.setsucursal_descripcion(rubroempleacuentacontable.getsucursal_descripcion());	
		rubroempleacuentacontableAsignar.setid_rubro_emplea(rubroempleacuentacontable.getid_rubro_emplea());
		rubroempleacuentacontableAsignar.setrubroemplea_descripcion(rubroempleacuentacontable.getrubroemplea_descripcion());	
		rubroempleacuentacontableAsignar.setid_cuenta_contable(rubroempleacuentacontable.getid_cuenta_contable());
		rubroempleacuentacontableAsignar.setcuentacontable_descripcion(rubroempleacuentacontable.getcuentacontable_descripcion());	
		rubroempleacuentacontableAsignar.setid_estructura(rubroempleacuentacontable.getid_estructura());
		rubroempleacuentacontableAsignar.setestructura_descripcion(rubroempleacuentacontable.getestructura_descripcion());	
	}
	
	public static void inicializarRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {
		try {
				rubroempleacuentacontable.setId(0L);	
					
				rubroempleacuentacontable.setid_empresa(-1L);	
				rubroempleacuentacontable.setid_sucursal(-1L);	
				rubroempleacuentacontable.setid_rubro_emplea(-1L);	
				rubroempleacuentacontable.setid_cuenta_contable(-1L);	
				rubroempleacuentacontable.setid_estructura(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRubroEmpleaCuentaContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaCuentaContableConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRubroEmpleaCuentaContable(String sTipo,Row row,Workbook workbook,RubroEmpleaCuentaContable rubroempleacuentacontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleacuentacontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleacuentacontable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleacuentacontable.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleacuentacontable.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleacuentacontable.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRubroEmpleaCuentaContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRubroEmpleaCuentaContable() {
		return this.sFinalQueryRubroEmpleaCuentaContable;
	}
	
	public void setsFinalQueryRubroEmpleaCuentaContable(String sFinalQueryRubroEmpleaCuentaContable) {
		this.sFinalQueryRubroEmpleaCuentaContable= sFinalQueryRubroEmpleaCuentaContable;
	}
	
	public Border resaltarSeleccionarRubroEmpleaCuentaContable=null;
	
	public Border setResaltarSeleccionarRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRubroEmpleaCuentaContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRubroEmpleaCuentaContable() {
		return this.resaltarSeleccionarRubroEmpleaCuentaContable;
	}
	
	public void setResaltarSeleccionarRubroEmpleaCuentaContable(Border borderResaltarSeleccionarRubroEmpleaCuentaContable) {
		this.resaltarSeleccionarRubroEmpleaCuentaContable= borderResaltarSeleccionarRubroEmpleaCuentaContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRubroEmpleaCuentaContable=null;
	public Boolean mostraridRubroEmpleaCuentaContable=true;
	public Boolean activaridRubroEmpleaCuentaContable=true;

	public Border resaltarid_empresaRubroEmpleaCuentaContable=null;
	public Boolean mostrarid_empresaRubroEmpleaCuentaContable=true;
	public Boolean activarid_empresaRubroEmpleaCuentaContable=true;
	public Boolean cargarid_empresaRubroEmpleaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRubroEmpleaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_sucursalRubroEmpleaCuentaContable=null;
	public Boolean mostrarid_sucursalRubroEmpleaCuentaContable=true;
	public Boolean activarid_sucursalRubroEmpleaCuentaContable=true;
	public Boolean cargarid_sucursalRubroEmpleaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRubroEmpleaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaRubroEmpleaCuentaContable=null;
	public Boolean mostrarid_rubro_empleaRubroEmpleaCuentaContable=true;
	public Boolean activarid_rubro_empleaRubroEmpleaCuentaContable=true;
	public Boolean cargarid_rubro_empleaRubroEmpleaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaRubroEmpleaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableRubroEmpleaCuentaContable=null;
	public Boolean mostrarid_cuenta_contableRubroEmpleaCuentaContable=true;
	public Boolean activarid_cuenta_contableRubroEmpleaCuentaContable=true;
	public Boolean cargarid_cuenta_contableRubroEmpleaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableRubroEmpleaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_estructuraRubroEmpleaCuentaContable=null;
	public Boolean mostrarid_estructuraRubroEmpleaCuentaContable=true;
	public Boolean activarid_estructuraRubroEmpleaCuentaContable=true;
	public Boolean cargarid_estructuraRubroEmpleaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraRubroEmpleaCuentaContable=false;//ConEventDepend=true

	
	

	public Border setResaltaridRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltaridRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRubroEmpleaCuentaContable() {
		return this.resaltaridRubroEmpleaCuentaContable;
	}

	public void setResaltaridRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltaridRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostraridRubroEmpleaCuentaContable() {
		return this.mostraridRubroEmpleaCuentaContable;
	}

	public void setMostraridRubroEmpleaCuentaContable(Boolean mostraridRubroEmpleaCuentaContable) {
		this.mostraridRubroEmpleaCuentaContable= mostraridRubroEmpleaCuentaContable;
	}

	public Boolean getActivaridRubroEmpleaCuentaContable() {
		return this.activaridRubroEmpleaCuentaContable;
	}

	public void setActivaridRubroEmpleaCuentaContable(Boolean activaridRubroEmpleaCuentaContable) {
		this.activaridRubroEmpleaCuentaContable= activaridRubroEmpleaCuentaContable;
	}

	public Border setResaltarid_empresaRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRubroEmpleaCuentaContable() {
		return this.resaltarid_empresaRubroEmpleaCuentaContable;
	}

	public void setResaltarid_empresaRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarid_empresaRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaRubroEmpleaCuentaContable() {
		return this.mostrarid_empresaRubroEmpleaCuentaContable;
	}

	public void setMostrarid_empresaRubroEmpleaCuentaContable(Boolean mostrarid_empresaRubroEmpleaCuentaContable) {
		this.mostrarid_empresaRubroEmpleaCuentaContable= mostrarid_empresaRubroEmpleaCuentaContable;
	}

	public Boolean getActivarid_empresaRubroEmpleaCuentaContable() {
		return this.activarid_empresaRubroEmpleaCuentaContable;
	}

	public void setActivarid_empresaRubroEmpleaCuentaContable(Boolean activarid_empresaRubroEmpleaCuentaContable) {
		this.activarid_empresaRubroEmpleaCuentaContable= activarid_empresaRubroEmpleaCuentaContable;
	}

	public Boolean getCargarid_empresaRubroEmpleaCuentaContable() {
		return this.cargarid_empresaRubroEmpleaCuentaContable;
	}

	public void setCargarid_empresaRubroEmpleaCuentaContable(Boolean cargarid_empresaRubroEmpleaCuentaContable) {
		this.cargarid_empresaRubroEmpleaCuentaContable= cargarid_empresaRubroEmpleaCuentaContable;
	}

	public Border setResaltarid_sucursalRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRubroEmpleaCuentaContable() {
		return this.resaltarid_sucursalRubroEmpleaCuentaContable;
	}

	public void setResaltarid_sucursalRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarid_sucursalRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRubroEmpleaCuentaContable() {
		return this.mostrarid_sucursalRubroEmpleaCuentaContable;
	}

	public void setMostrarid_sucursalRubroEmpleaCuentaContable(Boolean mostrarid_sucursalRubroEmpleaCuentaContable) {
		this.mostrarid_sucursalRubroEmpleaCuentaContable= mostrarid_sucursalRubroEmpleaCuentaContable;
	}

	public Boolean getActivarid_sucursalRubroEmpleaCuentaContable() {
		return this.activarid_sucursalRubroEmpleaCuentaContable;
	}

	public void setActivarid_sucursalRubroEmpleaCuentaContable(Boolean activarid_sucursalRubroEmpleaCuentaContable) {
		this.activarid_sucursalRubroEmpleaCuentaContable= activarid_sucursalRubroEmpleaCuentaContable;
	}

	public Boolean getCargarid_sucursalRubroEmpleaCuentaContable() {
		return this.cargarid_sucursalRubroEmpleaCuentaContable;
	}

	public void setCargarid_sucursalRubroEmpleaCuentaContable(Boolean cargarid_sucursalRubroEmpleaCuentaContable) {
		this.cargarid_sucursalRubroEmpleaCuentaContable= cargarid_sucursalRubroEmpleaCuentaContable;
	}

	public Border setResaltarid_rubro_empleaRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaRubroEmpleaCuentaContable() {
		return this.resaltarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public void setResaltarid_rubro_empleaRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarid_rubro_empleaRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaRubroEmpleaCuentaContable() {
		return this.mostrarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public void setMostrarid_rubro_empleaRubroEmpleaCuentaContable(Boolean mostrarid_rubro_empleaRubroEmpleaCuentaContable) {
		this.mostrarid_rubro_empleaRubroEmpleaCuentaContable= mostrarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public Boolean getActivarid_rubro_empleaRubroEmpleaCuentaContable() {
		return this.activarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public void setActivarid_rubro_empleaRubroEmpleaCuentaContable(Boolean activarid_rubro_empleaRubroEmpleaCuentaContable) {
		this.activarid_rubro_empleaRubroEmpleaCuentaContable= activarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public Boolean getCargarid_rubro_empleaRubroEmpleaCuentaContable() {
		return this.cargarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public void setCargarid_rubro_empleaRubroEmpleaCuentaContable(Boolean cargarid_rubro_empleaRubroEmpleaCuentaContable) {
		this.cargarid_rubro_empleaRubroEmpleaCuentaContable= cargarid_rubro_empleaRubroEmpleaCuentaContable;
	}

	public Border setResaltarid_cuenta_contableRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableRubroEmpleaCuentaContable() {
		return this.resaltarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public void setResaltarid_cuenta_contableRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contableRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableRubroEmpleaCuentaContable() {
		return this.mostrarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public void setMostrarid_cuenta_contableRubroEmpleaCuentaContable(Boolean mostrarid_cuenta_contableRubroEmpleaCuentaContable) {
		this.mostrarid_cuenta_contableRubroEmpleaCuentaContable= mostrarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public Boolean getActivarid_cuenta_contableRubroEmpleaCuentaContable() {
		return this.activarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public void setActivarid_cuenta_contableRubroEmpleaCuentaContable(Boolean activarid_cuenta_contableRubroEmpleaCuentaContable) {
		this.activarid_cuenta_contableRubroEmpleaCuentaContable= activarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public Boolean getCargarid_cuenta_contableRubroEmpleaCuentaContable() {
		return this.cargarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public void setCargarid_cuenta_contableRubroEmpleaCuentaContable(Boolean cargarid_cuenta_contableRubroEmpleaCuentaContable) {
		this.cargarid_cuenta_contableRubroEmpleaCuentaContable= cargarid_cuenta_contableRubroEmpleaCuentaContable;
	}

	public Border setResaltarid_estructuraRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleacuentacontableBeanSwingJInternalFrame.jTtoolBarRubroEmpleaCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_estructuraRubroEmpleaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraRubroEmpleaCuentaContable() {
		return this.resaltarid_estructuraRubroEmpleaCuentaContable;
	}

	public void setResaltarid_estructuraRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarid_estructuraRubroEmpleaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_estructuraRubroEmpleaCuentaContable() {
		return this.mostrarid_estructuraRubroEmpleaCuentaContable;
	}

	public void setMostrarid_estructuraRubroEmpleaCuentaContable(Boolean mostrarid_estructuraRubroEmpleaCuentaContable) {
		this.mostrarid_estructuraRubroEmpleaCuentaContable= mostrarid_estructuraRubroEmpleaCuentaContable;
	}

	public Boolean getActivarid_estructuraRubroEmpleaCuentaContable() {
		return this.activarid_estructuraRubroEmpleaCuentaContable;
	}

	public void setActivarid_estructuraRubroEmpleaCuentaContable(Boolean activarid_estructuraRubroEmpleaCuentaContable) {
		this.activarid_estructuraRubroEmpleaCuentaContable= activarid_estructuraRubroEmpleaCuentaContable;
	}

	public Boolean getCargarid_estructuraRubroEmpleaCuentaContable() {
		return this.cargarid_estructuraRubroEmpleaCuentaContable;
	}

	public void setCargarid_estructuraRubroEmpleaCuentaContable(Boolean cargarid_estructuraRubroEmpleaCuentaContable) {
		this.cargarid_estructuraRubroEmpleaCuentaContable= cargarid_estructuraRubroEmpleaCuentaContable;
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
		
		
		this.setMostraridRubroEmpleaCuentaContable(esInicial);
		this.setMostrarid_empresaRubroEmpleaCuentaContable(esInicial);
		this.setMostrarid_sucursalRubroEmpleaCuentaContable(esInicial);
		this.setMostrarid_rubro_empleaRubroEmpleaCuentaContable(esInicial);
		this.setMostrarid_cuenta_contableRubroEmpleaCuentaContable(esInicial);
		this.setMostrarid_estructuraRubroEmpleaCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.ID)) {
				this.setMostraridRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraRubroEmpleaCuentaContable(esAsigna);
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
		
		
		this.setActivaridRubroEmpleaCuentaContable(esInicial);
		this.setActivarid_empresaRubroEmpleaCuentaContable(esInicial);
		this.setActivarid_sucursalRubroEmpleaCuentaContable(esInicial);
		this.setActivarid_rubro_empleaRubroEmpleaCuentaContable(esInicial);
		this.setActivarid_cuenta_contableRubroEmpleaCuentaContable(esInicial);
		this.setActivarid_estructuraRubroEmpleaCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.ID)) {
				this.setActivaridRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraRubroEmpleaCuentaContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRubroEmpleaCuentaContable(esInicial);
		this.setResaltarid_empresaRubroEmpleaCuentaContable(esInicial);
		this.setResaltarid_sucursalRubroEmpleaCuentaContable(esInicial);
		this.setResaltarid_rubro_empleaRubroEmpleaCuentaContable(esInicial);
		this.setResaltarid_cuenta_contableRubroEmpleaCuentaContable(esInicial);
		this.setResaltarid_estructuraRubroEmpleaCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.ID)) {
				this.setResaltaridRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableRubroEmpleaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraRubroEmpleaCuentaContable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableRubroEmpleaCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableRubroEmpleaCuentaContable() {
		return this.mostrarFK_IdCuentaContableRubroEmpleaCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableRubroEmpleaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableRubroEmpleaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRubroEmpleaCuentaContable=true;

	public Boolean getMostrarFK_IdEmpresaRubroEmpleaCuentaContable() {
		return this.mostrarFK_IdEmpresaRubroEmpleaCuentaContable;
	}

	public void setMostrarFK_IdEmpresaRubroEmpleaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRubroEmpleaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraRubroEmpleaCuentaContable=true;

	public Boolean getMostrarFK_IdEstructuraRubroEmpleaCuentaContable() {
		return this.mostrarFK_IdEstructuraRubroEmpleaCuentaContable;
	}

	public void setMostrarFK_IdEstructuraRubroEmpleaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraRubroEmpleaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaRubroEmpleaCuentaContable=true;

	public Boolean getMostrarFK_IdRubroEmpleaRubroEmpleaCuentaContable() {
		return this.mostrarFK_IdRubroEmpleaRubroEmpleaCuentaContable;
	}

	public void setMostrarFK_IdRubroEmpleaRubroEmpleaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaRubroEmpleaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRubroEmpleaCuentaContable=true;

	public Boolean getMostrarFK_IdSucursalRubroEmpleaCuentaContable() {
		return this.mostrarFK_IdSucursalRubroEmpleaCuentaContable;
	}

	public void setMostrarFK_IdSucursalRubroEmpleaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRubroEmpleaCuentaContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableRubroEmpleaCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableRubroEmpleaCuentaContable() {
		return this.activarFK_IdCuentaContableRubroEmpleaCuentaContable;
	}

	public void setActivarFK_IdCuentaContableRubroEmpleaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableRubroEmpleaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRubroEmpleaCuentaContable=true;

	public Boolean getActivarFK_IdEmpresaRubroEmpleaCuentaContable() {
		return this.activarFK_IdEmpresaRubroEmpleaCuentaContable;
	}

	public void setActivarFK_IdEmpresaRubroEmpleaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRubroEmpleaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraRubroEmpleaCuentaContable=true;

	public Boolean getActivarFK_IdEstructuraRubroEmpleaCuentaContable() {
		return this.activarFK_IdEstructuraRubroEmpleaCuentaContable;
	}

	public void setActivarFK_IdEstructuraRubroEmpleaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraRubroEmpleaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaRubroEmpleaCuentaContable=true;

	public Boolean getActivarFK_IdRubroEmpleaRubroEmpleaCuentaContable() {
		return this.activarFK_IdRubroEmpleaRubroEmpleaCuentaContable;
	}

	public void setActivarFK_IdRubroEmpleaRubroEmpleaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaRubroEmpleaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRubroEmpleaCuentaContable=true;

	public Boolean getActivarFK_IdSucursalRubroEmpleaCuentaContable() {
		return this.activarFK_IdSucursalRubroEmpleaCuentaContable;
	}

	public void setActivarFK_IdSucursalRubroEmpleaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRubroEmpleaCuentaContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableRubroEmpleaCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableRubroEmpleaCuentaContable() {
		return this.resaltarFK_IdCuentaContableRubroEmpleaCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableRubroEmpleaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableRubroEmpleaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRubroEmpleaCuentaContable=null;

	public Border getResaltarFK_IdEmpresaRubroEmpleaCuentaContable() {
		return this.resaltarFK_IdEmpresaRubroEmpleaCuentaContable;
	}

	public void setResaltarFK_IdEmpresaRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRubroEmpleaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRubroEmpleaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraRubroEmpleaCuentaContable=null;

	public Border getResaltarFK_IdEstructuraRubroEmpleaCuentaContable() {
		return this.resaltarFK_IdEstructuraRubroEmpleaCuentaContable;
	}

	public void setResaltarFK_IdEstructuraRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdEstructuraRubroEmpleaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraRubroEmpleaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable=null;

	public Border getResaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable() {
		return this.resaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaRubroEmpleaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRubroEmpleaCuentaContable=null;

	public Border getResaltarFK_IdSucursalRubroEmpleaCuentaContable() {
		return this.resaltarFK_IdSucursalRubroEmpleaCuentaContable;
	}

	public void setResaltarFK_IdSucursalRubroEmpleaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdSucursalRubroEmpleaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRubroEmpleaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaCuentaContableBeanSwingJInternalFrame rubroempleacuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRubroEmpleaCuentaContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}