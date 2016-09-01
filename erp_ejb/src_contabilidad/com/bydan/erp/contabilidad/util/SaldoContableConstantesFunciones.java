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


import com.bydan.erp.contabilidad.util.SaldoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.SaldoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SaldoContableParameterGeneral;

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
final public class SaldoContableConstantesFunciones extends SaldoContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SaldoContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SaldoContable"+SaldoContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SaldoContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SaldoContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SaldoContableConstantesFunciones.SCHEMA+"_"+SaldoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SaldoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SaldoContableConstantesFunciones.SCHEMA+"_"+SaldoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SaldoContableConstantesFunciones.SCHEMA+"_"+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SaldoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SaldoContableConstantesFunciones.SCHEMA+"_"+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SaldoContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SaldoContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SaldoContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SaldoContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Saldo Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Saldo Contable";
	public static final String SCLASSWEBTITULO_LOWER="Saldo Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SaldoContable";
	public static final String OBJECTNAME="saldocontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="saldo_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select saldocontable from "+SaldoContableConstantesFunciones.SPERSISTENCENAME+" saldocontable";
	public static String QUERYSELECTNATIVE="select "+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".version_row,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_empresa,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_sucursal,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_ejercicio,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_periodo,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_anio,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_mes,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".debito_mone_local,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".credito_mone_local,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".saldo_mone_local,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".debito_mone_extra,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".credito_mone_extra,"+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME+".saldo_mone_extra from "+SaldoContableConstantesFunciones.SCHEMA+"."+SaldoContableConstantesFunciones.TABLENAME;//+" as "+SaldoContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SaldoContableConstantesFuncionesAdditional saldocontableConstantesFuncionesAdditional=null;
	
	public SaldoContableConstantesFuncionesAdditional getSaldoContableConstantesFuncionesAdditional() {
		return this.saldocontableConstantesFuncionesAdditional;
	}
	
	public void setSaldoContableConstantesFuncionesAdditional(SaldoContableConstantesFuncionesAdditional saldocontableConstantesFuncionesAdditional) {
		try {
			this.saldocontableConstantesFuncionesAdditional=saldocontableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String SALDOMONELOCAL= "saldo_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String SALDOMONEEXTRA= "saldo_mone_extra";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Moneda Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Moneda Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_SALDOMONELOCAL= "Saldo Moneda Local";
		public static final String LABEL_SALDOMONELOCAL_LOWER= "Saldo Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Moneda Extranjera";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Moneda Extrajera";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_SALDOMONEEXTRA= "Saldo Moneda Extrajera";
		public static final String LABEL_SALDOMONEEXTRA_LOWER= "Saldo Mone Extra";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getSaldoContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDEJERCICIO)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDPERIODO)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDANIO)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDMES)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.SALDOMONELOCAL)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(SaldoContableConstantesFunciones.SALDOMONEEXTRA)) {sLabelColumna=SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSaldoContableDescripcion(SaldoContable saldocontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(saldocontable !=null/* && saldocontable.getId()!=0*/) {
			if(saldocontable.getId()!=null) {
				sDescripcion=saldocontable.getId().toString();
			}//saldocontablesaldocontable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSaldoContableDescripcionDetallado(SaldoContable saldocontable) {
		String sDescripcion="";
			
		sDescripcion+=SaldoContableConstantesFunciones.ID+"=";
		sDescripcion+=saldocontable.getId().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=saldocontable.getVersionRow().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=saldocontable.getid_empresa().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=saldocontable.getid_sucursal().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=saldocontable.getid_ejercicio().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=saldocontable.getid_periodo().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDANIO+"=";
		sDescripcion+=saldocontable.getid_anio().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDMES+"=";
		sDescripcion+=saldocontable.getid_mes().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=saldocontable.getid_cuenta_contable().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=saldocontable.getdebito_mone_local().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=saldocontable.getcredito_mone_local().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.SALDOMONELOCAL+"=";
		sDescripcion+=saldocontable.getsaldo_mone_local().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=saldocontable.getdebito_mone_extra().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=saldocontable.getcredito_mone_extra().toString()+",";
		sDescripcion+=SaldoContableConstantesFunciones.SALDOMONEEXTRA+"=";
		sDescripcion+=saldocontable.getsaldo_mone_extra().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSaldoContableDescripcion(SaldoContable saldocontable,String sValor) throws Exception {			
		if(saldocontable !=null) {
			//saldocontablesaldocontable.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSaldoContable(SaldoContable saldocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosSaldoContables(List<SaldoContable> saldocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldoContable saldocontable: saldocontables) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldoContable(SaldoContable saldocontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && saldocontable.getConCambioAuxiliar()) {
			saldocontable.setIsDeleted(saldocontable.getIsDeletedAuxiliar());	
			saldocontable.setIsNew(saldocontable.getIsNewAuxiliar());	
			saldocontable.setIsChanged(saldocontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			saldocontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			saldocontable.setIsDeletedAuxiliar(false);	
			saldocontable.setIsNewAuxiliar(false);	
			saldocontable.setIsChangedAuxiliar(false);
			
			saldocontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldoContables(List<SaldoContable> saldocontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SaldoContable saldocontable : saldocontables) {
			if(conAsignarBase && saldocontable.getConCambioAuxiliar()) {
				saldocontable.setIsDeleted(saldocontable.getIsDeletedAuxiliar());	
				saldocontable.setIsNew(saldocontable.getIsNewAuxiliar());	
				saldocontable.setIsChanged(saldocontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				saldocontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				saldocontable.setIsDeletedAuxiliar(false);	
				saldocontable.setIsNewAuxiliar(false);	
				saldocontable.setIsChangedAuxiliar(false);
				
				saldocontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSaldoContable(SaldoContable saldocontable,Boolean conEnteros) throws Exception  {
		saldocontable.setdebito_mone_local(0.0);
		saldocontable.setcredito_mone_local(0.0);
		saldocontable.setsaldo_mone_local(0.0);
		saldocontable.setdebito_mone_extra(0.0);
		saldocontable.setcredito_mone_extra(0.0);
		saldocontable.setsaldo_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSaldoContables(List<SaldoContable> saldocontables,Boolean conEnteros) throws Exception  {
		
		for(SaldoContable saldocontable: saldocontables) {
			saldocontable.setdebito_mone_local(0.0);
			saldocontable.setcredito_mone_local(0.0);
			saldocontable.setsaldo_mone_local(0.0);
			saldocontable.setdebito_mone_extra(0.0);
			saldocontable.setcredito_mone_extra(0.0);
			saldocontable.setsaldo_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSaldoContable(List<SaldoContable> saldocontables,SaldoContable saldocontableAux) throws Exception  {
		SaldoContableConstantesFunciones.InicializarValoresSaldoContable(saldocontableAux,true);
		
		for(SaldoContable saldocontable: saldocontables) {
			if(saldocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldocontableAux.setdebito_mone_local(saldocontableAux.getdebito_mone_local()+saldocontable.getdebito_mone_local());			
			saldocontableAux.setcredito_mone_local(saldocontableAux.getcredito_mone_local()+saldocontable.getcredito_mone_local());			
			saldocontableAux.setsaldo_mone_local(saldocontableAux.getsaldo_mone_local()+saldocontable.getsaldo_mone_local());			
			saldocontableAux.setdebito_mone_extra(saldocontableAux.getdebito_mone_extra()+saldocontable.getdebito_mone_extra());			
			saldocontableAux.setcredito_mone_extra(saldocontableAux.getcredito_mone_extra()+saldocontable.getcredito_mone_extra());			
			saldocontableAux.setsaldo_mone_extra(saldocontableAux.getsaldo_mone_extra()+saldocontable.getsaldo_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SaldoContableConstantesFunciones.getArrayColumnasGlobalesSaldoContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldoContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoContableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoContableConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoContableConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoContableConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldoContableConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldoContableConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSaldoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldoContable> saldocontables,SaldoContable saldocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldoContable saldocontableAux: saldocontables) {
			if(saldocontableAux!=null && saldocontable!=null) {
				if((saldocontableAux.getId()==null && saldocontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(saldocontableAux.getId()!=null && saldocontable.getId()!=null){
					if(saldocontableAux.getId().equals(saldocontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldoContable(List<SaldoContable> saldocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double saldo_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
		Double saldo_mone_extraTotal=0.0;
	
		for(SaldoContable saldocontable: saldocontables) {			
			if(saldocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=saldocontable.getdebito_mone_local();
			credito_mone_localTotal+=saldocontable.getcredito_mone_local();
			saldo_mone_localTotal+=saldocontable.getsaldo_mone_local();
			debito_mone_extraTotal+=saldocontable.getdebito_mone_extra();
			credito_mone_extraTotal+=saldocontable.getcredito_mone_extra();
			saldo_mone_extraTotal+=saldocontable.getsaldo_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.SALDOMONELOCAL);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL);
		datoGeneral.setdValorDouble(saldo_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldoContableConstantesFunciones.SALDOMONEEXTRA);
		datoGeneral.setsDescripcion(SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA);
		datoGeneral.setdValorDouble(saldo_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSaldoContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_ID, SaldoContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_VERSIONROW, SaldoContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDEMPRESA, SaldoContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDSUCURSAL, SaldoContableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDEJERCICIO, SaldoContableConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDPERIODO, SaldoContableConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDANIO, SaldoContableConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDMES, SaldoContableConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_IDCUENTACONTABLE, SaldoContableConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL, SaldoContableConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL, SaldoContableConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL, SaldoContableConstantesFunciones.SALDOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA, SaldoContableConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA, SaldoContableConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA, SaldoContableConstantesFunciones.SALDOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSaldoContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.SALDOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldoContableConstantesFunciones.SALDOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoContable() throws Exception  {
		return SaldoContableConstantesFunciones.getTiposSeleccionarSaldoContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoContable(Boolean conFk) throws Exception  {
		return SaldoContableConstantesFunciones.getTiposSeleccionarSaldoContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldoContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA);
			reporte.setsDescripcion(SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSaldoContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSaldoContable(SaldoContable saldocontableAux) throws Exception {
		
			saldocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldocontableAux.getEmpresa()));
			saldocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldocontableAux.getSucursal()));
			saldocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(saldocontableAux.getEjercicio()));
			saldocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(saldocontableAux.getPeriodo()));
			saldocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(saldocontableAux.getAnio()));
			saldocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(saldocontableAux.getMes()));
			saldocontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(saldocontableAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSaldoContable(List<SaldoContable> saldocontablesTemp) throws Exception {
		for(SaldoContable saldocontableAux:saldocontablesTemp) {
			
			saldocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldocontableAux.getEmpresa()));
			saldocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(saldocontableAux.getSucursal()));
			saldocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(saldocontableAux.getEjercicio()));
			saldocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(saldocontableAux.getPeriodo()));
			saldocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(saldocontableAux.getAnio()));
			saldocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(saldocontableAux.getMes()));
			saldocontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(saldocontableAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSaldoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSaldoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldoContableConstantesFunciones.getClassesRelationshipsOfSaldoContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldoContableConstantesFunciones.getClassesRelationshipsFromStringsOfSaldoContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SaldoContable saldocontable,List<SaldoContable> saldocontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SaldoContable saldocontableEncontrado=null;
			
			for(SaldoContable saldocontableLocal:saldocontables) {
				if(saldocontableLocal.getId().equals(saldocontable.getId())) {
					saldocontableEncontrado=saldocontableLocal;
					
					saldocontableLocal.setIsChanged(saldocontable.getIsChanged());
					saldocontableLocal.setIsNew(saldocontable.getIsNew());
					saldocontableLocal.setIsDeleted(saldocontable.getIsDeleted());
					
					saldocontableLocal.setGeneralEntityOriginal(saldocontable.getGeneralEntityOriginal());
					
					saldocontableLocal.setId(saldocontable.getId());	
					saldocontableLocal.setVersionRow(saldocontable.getVersionRow());	
					saldocontableLocal.setid_empresa(saldocontable.getid_empresa());	
					saldocontableLocal.setid_sucursal(saldocontable.getid_sucursal());	
					saldocontableLocal.setid_ejercicio(saldocontable.getid_ejercicio());	
					saldocontableLocal.setid_periodo(saldocontable.getid_periodo());	
					saldocontableLocal.setid_anio(saldocontable.getid_anio());	
					saldocontableLocal.setid_mes(saldocontable.getid_mes());	
					saldocontableLocal.setid_cuenta_contable(saldocontable.getid_cuenta_contable());	
					saldocontableLocal.setdebito_mone_local(saldocontable.getdebito_mone_local());	
					saldocontableLocal.setcredito_mone_local(saldocontable.getcredito_mone_local());	
					saldocontableLocal.setsaldo_mone_local(saldocontable.getsaldo_mone_local());	
					saldocontableLocal.setdebito_mone_extra(saldocontable.getdebito_mone_extra());	
					saldocontableLocal.setcredito_mone_extra(saldocontable.getcredito_mone_extra());	
					saldocontableLocal.setsaldo_mone_extra(saldocontable.getsaldo_mone_extra());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!saldocontable.getIsDeleted()) {
				if(!existe) {
					saldocontables.add(saldocontable);
				}
			} else {
				if(saldocontableEncontrado!=null && permiteQuitar)  {
					saldocontables.remove(saldocontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SaldoContable saldocontable,List<SaldoContable> saldocontables) throws Exception {
		try	{			
			for(SaldoContable saldocontableLocal:saldocontables) {
				if(saldocontableLocal.getId().equals(saldocontable.getId())) {
					saldocontableLocal.setIsSelected(saldocontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSaldoContable(List<SaldoContable> saldocontablesAux) throws Exception {
		//this.saldocontablesAux=saldocontablesAux;
		
		for(SaldoContable saldocontableAux:saldocontablesAux) {
			if(saldocontableAux.getIsChanged()) {
				saldocontableAux.setIsChanged(false);
			}		
			
			if(saldocontableAux.getIsNew()) {
				saldocontableAux.setIsNew(false);
			}	
			
			if(saldocontableAux.getIsDeleted()) {
				saldocontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSaldoContable(SaldoContable saldocontableAux) throws Exception {
		//this.saldocontableAux=saldocontableAux;
		
			if(saldocontableAux.getIsChanged()) {
				saldocontableAux.setIsChanged(false);
			}		
			
			if(saldocontableAux.getIsNew()) {
				saldocontableAux.setIsNew(false);
			}	
			
			if(saldocontableAux.getIsDeleted()) {
				saldocontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SaldoContable saldocontableAsignar,SaldoContable saldocontable) throws Exception {
		saldocontableAsignar.setId(saldocontable.getId());	
		saldocontableAsignar.setVersionRow(saldocontable.getVersionRow());	
		saldocontableAsignar.setid_empresa(saldocontable.getid_empresa());
		saldocontableAsignar.setempresa_descripcion(saldocontable.getempresa_descripcion());	
		saldocontableAsignar.setid_sucursal(saldocontable.getid_sucursal());
		saldocontableAsignar.setsucursal_descripcion(saldocontable.getsucursal_descripcion());	
		saldocontableAsignar.setid_ejercicio(saldocontable.getid_ejercicio());
		saldocontableAsignar.setejercicio_descripcion(saldocontable.getejercicio_descripcion());	
		saldocontableAsignar.setid_periodo(saldocontable.getid_periodo());
		saldocontableAsignar.setperiodo_descripcion(saldocontable.getperiodo_descripcion());	
		saldocontableAsignar.setid_anio(saldocontable.getid_anio());
		saldocontableAsignar.setanio_descripcion(saldocontable.getanio_descripcion());	
		saldocontableAsignar.setid_mes(saldocontable.getid_mes());
		saldocontableAsignar.setmes_descripcion(saldocontable.getmes_descripcion());	
		saldocontableAsignar.setid_cuenta_contable(saldocontable.getid_cuenta_contable());
		saldocontableAsignar.setcuentacontable_descripcion(saldocontable.getcuentacontable_descripcion());	
		saldocontableAsignar.setdebito_mone_local(saldocontable.getdebito_mone_local());	
		saldocontableAsignar.setcredito_mone_local(saldocontable.getcredito_mone_local());	
		saldocontableAsignar.setsaldo_mone_local(saldocontable.getsaldo_mone_local());	
		saldocontableAsignar.setdebito_mone_extra(saldocontable.getdebito_mone_extra());	
		saldocontableAsignar.setcredito_mone_extra(saldocontable.getcredito_mone_extra());	
		saldocontableAsignar.setsaldo_mone_extra(saldocontable.getsaldo_mone_extra());	
	}
	
	public static void inicializarSaldoContable(SaldoContable saldocontable) throws Exception {
		try {
				saldocontable.setId(0L);	
					
				saldocontable.setid_empresa(-1L);	
				saldocontable.setid_sucursal(-1L);	
				saldocontable.setid_ejercicio(-1L);	
				saldocontable.setid_periodo(-1L);	
				saldocontable.setid_anio(null);	
				saldocontable.setid_mes(null);	
				saldocontable.setid_cuenta_contable(-1L);	
				saldocontable.setdebito_mone_local(0.0);	
				saldocontable.setcredito_mone_local(0.0);	
				saldocontable.setsaldo_mone_local(0.0);	
				saldocontable.setdebito_mone_extra(0.0);	
				saldocontable.setcredito_mone_extra(0.0);	
				saldocontable.setsaldo_mone_extra(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSaldoContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_SALDOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldoContableConstantesFunciones.LABEL_SALDOMONEEXTRA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSaldoContable(String sTipo,Row row,Workbook workbook,SaldoContable saldocontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getsaldo_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldocontable.getsaldo_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySaldoContable=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySaldoContable() {
		return this.sFinalQuerySaldoContable;
	}
	
	public void setsFinalQuerySaldoContable(String sFinalQuerySaldoContable) {
		this.sFinalQuerySaldoContable= sFinalQuerySaldoContable;
	}
	
	public Border resaltarSeleccionarSaldoContable=null;
	
	public Border setResaltarSeleccionarSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSaldoContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSaldoContable() {
		return this.resaltarSeleccionarSaldoContable;
	}
	
	public void setResaltarSeleccionarSaldoContable(Border borderResaltarSeleccionarSaldoContable) {
		this.resaltarSeleccionarSaldoContable= borderResaltarSeleccionarSaldoContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSaldoContable=null;
	public Boolean mostraridSaldoContable=true;
	public Boolean activaridSaldoContable=true;

	public Border resaltarid_empresaSaldoContable=null;
	public Boolean mostrarid_empresaSaldoContable=true;
	public Boolean activarid_empresaSaldoContable=true;
	public Boolean cargarid_empresaSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_sucursalSaldoContable=null;
	public Boolean mostrarid_sucursalSaldoContable=true;
	public Boolean activarid_sucursalSaldoContable=true;
	public Boolean cargarid_sucursalSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_ejercicioSaldoContable=null;
	public Boolean mostrarid_ejercicioSaldoContable=true;
	public Boolean activarid_ejercicioSaldoContable=true;
	public Boolean cargarid_ejercicioSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_periodoSaldoContable=null;
	public Boolean mostrarid_periodoSaldoContable=true;
	public Boolean activarid_periodoSaldoContable=true;
	public Boolean cargarid_periodoSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_anioSaldoContable=null;
	public Boolean mostrarid_anioSaldoContable=true;
	public Boolean activarid_anioSaldoContable=false;
	public Boolean cargarid_anioSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_mesSaldoContable=null;
	public Boolean mostrarid_mesSaldoContable=true;
	public Boolean activarid_mesSaldoContable=false;
	public Boolean cargarid_mesSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesSaldoContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableSaldoContable=null;
	public Boolean mostrarid_cuenta_contableSaldoContable=true;
	public Boolean activarid_cuenta_contableSaldoContable=true;
	public Boolean cargarid_cuenta_contableSaldoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableSaldoContable=false;//ConEventDepend=true

	public Border resaltardebito_mone_localSaldoContable=null;
	public Boolean mostrardebito_mone_localSaldoContable=true;
	public Boolean activardebito_mone_localSaldoContable=true;

	public Border resaltarcredito_mone_localSaldoContable=null;
	public Boolean mostrarcredito_mone_localSaldoContable=true;
	public Boolean activarcredito_mone_localSaldoContable=true;

	public Border resaltarsaldo_mone_localSaldoContable=null;
	public Boolean mostrarsaldo_mone_localSaldoContable=true;
	public Boolean activarsaldo_mone_localSaldoContable=true;

	public Border resaltardebito_mone_extraSaldoContable=null;
	public Boolean mostrardebito_mone_extraSaldoContable=true;
	public Boolean activardebito_mone_extraSaldoContable=true;

	public Border resaltarcredito_mone_extraSaldoContable=null;
	public Boolean mostrarcredito_mone_extraSaldoContable=true;
	public Boolean activarcredito_mone_extraSaldoContable=true;

	public Border resaltarsaldo_mone_extraSaldoContable=null;
	public Boolean mostrarsaldo_mone_extraSaldoContable=true;
	public Boolean activarsaldo_mone_extraSaldoContable=true;

	
	

	public Border setResaltaridSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltaridSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSaldoContable() {
		return this.resaltaridSaldoContable;
	}

	public void setResaltaridSaldoContable(Border borderResaltar) {
		this.resaltaridSaldoContable= borderResaltar;
	}

	public Boolean getMostraridSaldoContable() {
		return this.mostraridSaldoContable;
	}

	public void setMostraridSaldoContable(Boolean mostraridSaldoContable) {
		this.mostraridSaldoContable= mostraridSaldoContable;
	}

	public Boolean getActivaridSaldoContable() {
		return this.activaridSaldoContable;
	}

	public void setActivaridSaldoContable(Boolean activaridSaldoContable) {
		this.activaridSaldoContable= activaridSaldoContable;
	}

	public Border setResaltarid_empresaSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSaldoContable() {
		return this.resaltarid_empresaSaldoContable;
	}

	public void setResaltarid_empresaSaldoContable(Border borderResaltar) {
		this.resaltarid_empresaSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaSaldoContable() {
		return this.mostrarid_empresaSaldoContable;
	}

	public void setMostrarid_empresaSaldoContable(Boolean mostrarid_empresaSaldoContable) {
		this.mostrarid_empresaSaldoContable= mostrarid_empresaSaldoContable;
	}

	public Boolean getActivarid_empresaSaldoContable() {
		return this.activarid_empresaSaldoContable;
	}

	public void setActivarid_empresaSaldoContable(Boolean activarid_empresaSaldoContable) {
		this.activarid_empresaSaldoContable= activarid_empresaSaldoContable;
	}

	public Boolean getCargarid_empresaSaldoContable() {
		return this.cargarid_empresaSaldoContable;
	}

	public void setCargarid_empresaSaldoContable(Boolean cargarid_empresaSaldoContable) {
		this.cargarid_empresaSaldoContable= cargarid_empresaSaldoContable;
	}

	public Border setResaltarid_sucursalSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSaldoContable() {
		return this.resaltarid_sucursalSaldoContable;
	}

	public void setResaltarid_sucursalSaldoContable(Border borderResaltar) {
		this.resaltarid_sucursalSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSaldoContable() {
		return this.mostrarid_sucursalSaldoContable;
	}

	public void setMostrarid_sucursalSaldoContable(Boolean mostrarid_sucursalSaldoContable) {
		this.mostrarid_sucursalSaldoContable= mostrarid_sucursalSaldoContable;
	}

	public Boolean getActivarid_sucursalSaldoContable() {
		return this.activarid_sucursalSaldoContable;
	}

	public void setActivarid_sucursalSaldoContable(Boolean activarid_sucursalSaldoContable) {
		this.activarid_sucursalSaldoContable= activarid_sucursalSaldoContable;
	}

	public Boolean getCargarid_sucursalSaldoContable() {
		return this.cargarid_sucursalSaldoContable;
	}

	public void setCargarid_sucursalSaldoContable(Boolean cargarid_sucursalSaldoContable) {
		this.cargarid_sucursalSaldoContable= cargarid_sucursalSaldoContable;
	}

	public Border setResaltarid_ejercicioSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioSaldoContable() {
		return this.resaltarid_ejercicioSaldoContable;
	}

	public void setResaltarid_ejercicioSaldoContable(Border borderResaltar) {
		this.resaltarid_ejercicioSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioSaldoContable() {
		return this.mostrarid_ejercicioSaldoContable;
	}

	public void setMostrarid_ejercicioSaldoContable(Boolean mostrarid_ejercicioSaldoContable) {
		this.mostrarid_ejercicioSaldoContable= mostrarid_ejercicioSaldoContable;
	}

	public Boolean getActivarid_ejercicioSaldoContable() {
		return this.activarid_ejercicioSaldoContable;
	}

	public void setActivarid_ejercicioSaldoContable(Boolean activarid_ejercicioSaldoContable) {
		this.activarid_ejercicioSaldoContable= activarid_ejercicioSaldoContable;
	}

	public Boolean getCargarid_ejercicioSaldoContable() {
		return this.cargarid_ejercicioSaldoContable;
	}

	public void setCargarid_ejercicioSaldoContable(Boolean cargarid_ejercicioSaldoContable) {
		this.cargarid_ejercicioSaldoContable= cargarid_ejercicioSaldoContable;
	}

	public Border setResaltarid_periodoSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_periodoSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoSaldoContable() {
		return this.resaltarid_periodoSaldoContable;
	}

	public void setResaltarid_periodoSaldoContable(Border borderResaltar) {
		this.resaltarid_periodoSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_periodoSaldoContable() {
		return this.mostrarid_periodoSaldoContable;
	}

	public void setMostrarid_periodoSaldoContable(Boolean mostrarid_periodoSaldoContable) {
		this.mostrarid_periodoSaldoContable= mostrarid_periodoSaldoContable;
	}

	public Boolean getActivarid_periodoSaldoContable() {
		return this.activarid_periodoSaldoContable;
	}

	public void setActivarid_periodoSaldoContable(Boolean activarid_periodoSaldoContable) {
		this.activarid_periodoSaldoContable= activarid_periodoSaldoContable;
	}

	public Boolean getCargarid_periodoSaldoContable() {
		return this.cargarid_periodoSaldoContable;
	}

	public void setCargarid_periodoSaldoContable(Boolean cargarid_periodoSaldoContable) {
		this.cargarid_periodoSaldoContable= cargarid_periodoSaldoContable;
	}

	public Border setResaltarid_anioSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_anioSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioSaldoContable() {
		return this.resaltarid_anioSaldoContable;
	}

	public void setResaltarid_anioSaldoContable(Border borderResaltar) {
		this.resaltarid_anioSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_anioSaldoContable() {
		return this.mostrarid_anioSaldoContable;
	}

	public void setMostrarid_anioSaldoContable(Boolean mostrarid_anioSaldoContable) {
		this.mostrarid_anioSaldoContable= mostrarid_anioSaldoContable;
	}

	public Boolean getActivarid_anioSaldoContable() {
		return this.activarid_anioSaldoContable;
	}

	public void setActivarid_anioSaldoContable(Boolean activarid_anioSaldoContable) {
		this.activarid_anioSaldoContable= activarid_anioSaldoContable;
	}

	public Boolean getCargarid_anioSaldoContable() {
		return this.cargarid_anioSaldoContable;
	}

	public void setCargarid_anioSaldoContable(Boolean cargarid_anioSaldoContable) {
		this.cargarid_anioSaldoContable= cargarid_anioSaldoContable;
	}

	public Border setResaltarid_mesSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_mesSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesSaldoContable() {
		return this.resaltarid_mesSaldoContable;
	}

	public void setResaltarid_mesSaldoContable(Border borderResaltar) {
		this.resaltarid_mesSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_mesSaldoContable() {
		return this.mostrarid_mesSaldoContable;
	}

	public void setMostrarid_mesSaldoContable(Boolean mostrarid_mesSaldoContable) {
		this.mostrarid_mesSaldoContable= mostrarid_mesSaldoContable;
	}

	public Boolean getActivarid_mesSaldoContable() {
		return this.activarid_mesSaldoContable;
	}

	public void setActivarid_mesSaldoContable(Boolean activarid_mesSaldoContable) {
		this.activarid_mesSaldoContable= activarid_mesSaldoContable;
	}

	public Boolean getCargarid_mesSaldoContable() {
		return this.cargarid_mesSaldoContable;
	}

	public void setCargarid_mesSaldoContable(Boolean cargarid_mesSaldoContable) {
		this.cargarid_mesSaldoContable= cargarid_mesSaldoContable;
	}

	public Border setResaltarid_cuenta_contableSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableSaldoContable() {
		return this.resaltarid_cuenta_contableSaldoContable;
	}

	public void setResaltarid_cuenta_contableSaldoContable(Border borderResaltar) {
		this.resaltarid_cuenta_contableSaldoContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableSaldoContable() {
		return this.mostrarid_cuenta_contableSaldoContable;
	}

	public void setMostrarid_cuenta_contableSaldoContable(Boolean mostrarid_cuenta_contableSaldoContable) {
		this.mostrarid_cuenta_contableSaldoContable= mostrarid_cuenta_contableSaldoContable;
	}

	public Boolean getActivarid_cuenta_contableSaldoContable() {
		return this.activarid_cuenta_contableSaldoContable;
	}

	public void setActivarid_cuenta_contableSaldoContable(Boolean activarid_cuenta_contableSaldoContable) {
		this.activarid_cuenta_contableSaldoContable= activarid_cuenta_contableSaldoContable;
	}

	public Boolean getCargarid_cuenta_contableSaldoContable() {
		return this.cargarid_cuenta_contableSaldoContable;
	}

	public void setCargarid_cuenta_contableSaldoContable(Boolean cargarid_cuenta_contableSaldoContable) {
		this.cargarid_cuenta_contableSaldoContable= cargarid_cuenta_contableSaldoContable;
	}

	public Border setResaltardebito_mone_localSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localSaldoContable() {
		return this.resaltardebito_mone_localSaldoContable;
	}

	public void setResaltardebito_mone_localSaldoContable(Border borderResaltar) {
		this.resaltardebito_mone_localSaldoContable= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localSaldoContable() {
		return this.mostrardebito_mone_localSaldoContable;
	}

	public void setMostrardebito_mone_localSaldoContable(Boolean mostrardebito_mone_localSaldoContable) {
		this.mostrardebito_mone_localSaldoContable= mostrardebito_mone_localSaldoContable;
	}

	public Boolean getActivardebito_mone_localSaldoContable() {
		return this.activardebito_mone_localSaldoContable;
	}

	public void setActivardebito_mone_localSaldoContable(Boolean activardebito_mone_localSaldoContable) {
		this.activardebito_mone_localSaldoContable= activardebito_mone_localSaldoContable;
	}

	public Border setResaltarcredito_mone_localSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localSaldoContable() {
		return this.resaltarcredito_mone_localSaldoContable;
	}

	public void setResaltarcredito_mone_localSaldoContable(Border borderResaltar) {
		this.resaltarcredito_mone_localSaldoContable= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localSaldoContable() {
		return this.mostrarcredito_mone_localSaldoContable;
	}

	public void setMostrarcredito_mone_localSaldoContable(Boolean mostrarcredito_mone_localSaldoContable) {
		this.mostrarcredito_mone_localSaldoContable= mostrarcredito_mone_localSaldoContable;
	}

	public Boolean getActivarcredito_mone_localSaldoContable() {
		return this.activarcredito_mone_localSaldoContable;
	}

	public void setActivarcredito_mone_localSaldoContable(Boolean activarcredito_mone_localSaldoContable) {
		this.activarcredito_mone_localSaldoContable= activarcredito_mone_localSaldoContable;
	}

	public Border setResaltarsaldo_mone_localSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarsaldo_mone_localSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_mone_localSaldoContable() {
		return this.resaltarsaldo_mone_localSaldoContable;
	}

	public void setResaltarsaldo_mone_localSaldoContable(Border borderResaltar) {
		this.resaltarsaldo_mone_localSaldoContable= borderResaltar;
	}

	public Boolean getMostrarsaldo_mone_localSaldoContable() {
		return this.mostrarsaldo_mone_localSaldoContable;
	}

	public void setMostrarsaldo_mone_localSaldoContable(Boolean mostrarsaldo_mone_localSaldoContable) {
		this.mostrarsaldo_mone_localSaldoContable= mostrarsaldo_mone_localSaldoContable;
	}

	public Boolean getActivarsaldo_mone_localSaldoContable() {
		return this.activarsaldo_mone_localSaldoContable;
	}

	public void setActivarsaldo_mone_localSaldoContable(Boolean activarsaldo_mone_localSaldoContable) {
		this.activarsaldo_mone_localSaldoContable= activarsaldo_mone_localSaldoContable;
	}

	public Border setResaltardebito_mone_extraSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltardebito_mone_extraSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraSaldoContable() {
		return this.resaltardebito_mone_extraSaldoContable;
	}

	public void setResaltardebito_mone_extraSaldoContable(Border borderResaltar) {
		this.resaltardebito_mone_extraSaldoContable= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraSaldoContable() {
		return this.mostrardebito_mone_extraSaldoContable;
	}

	public void setMostrardebito_mone_extraSaldoContable(Boolean mostrardebito_mone_extraSaldoContable) {
		this.mostrardebito_mone_extraSaldoContable= mostrardebito_mone_extraSaldoContable;
	}

	public Boolean getActivardebito_mone_extraSaldoContable() {
		return this.activardebito_mone_extraSaldoContable;
	}

	public void setActivardebito_mone_extraSaldoContable(Boolean activardebito_mone_extraSaldoContable) {
		this.activardebito_mone_extraSaldoContable= activardebito_mone_extraSaldoContable;
	}

	public Border setResaltarcredito_mone_extraSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_extraSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraSaldoContable() {
		return this.resaltarcredito_mone_extraSaldoContable;
	}

	public void setResaltarcredito_mone_extraSaldoContable(Border borderResaltar) {
		this.resaltarcredito_mone_extraSaldoContable= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraSaldoContable() {
		return this.mostrarcredito_mone_extraSaldoContable;
	}

	public void setMostrarcredito_mone_extraSaldoContable(Boolean mostrarcredito_mone_extraSaldoContable) {
		this.mostrarcredito_mone_extraSaldoContable= mostrarcredito_mone_extraSaldoContable;
	}

	public Boolean getActivarcredito_mone_extraSaldoContable() {
		return this.activarcredito_mone_extraSaldoContable;
	}

	public void setActivarcredito_mone_extraSaldoContable(Boolean activarcredito_mone_extraSaldoContable) {
		this.activarcredito_mone_extraSaldoContable= activarcredito_mone_extraSaldoContable;
	}

	public Border setResaltarsaldo_mone_extraSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldocontableBeanSwingJInternalFrame.jTtoolBarSaldoContable.setBorder(borderResaltar);
		
		this.resaltarsaldo_mone_extraSaldoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_mone_extraSaldoContable() {
		return this.resaltarsaldo_mone_extraSaldoContable;
	}

	public void setResaltarsaldo_mone_extraSaldoContable(Border borderResaltar) {
		this.resaltarsaldo_mone_extraSaldoContable= borderResaltar;
	}

	public Boolean getMostrarsaldo_mone_extraSaldoContable() {
		return this.mostrarsaldo_mone_extraSaldoContable;
	}

	public void setMostrarsaldo_mone_extraSaldoContable(Boolean mostrarsaldo_mone_extraSaldoContable) {
		this.mostrarsaldo_mone_extraSaldoContable= mostrarsaldo_mone_extraSaldoContable;
	}

	public Boolean getActivarsaldo_mone_extraSaldoContable() {
		return this.activarsaldo_mone_extraSaldoContable;
	}

	public void setActivarsaldo_mone_extraSaldoContable(Boolean activarsaldo_mone_extraSaldoContable) {
		this.activarsaldo_mone_extraSaldoContable= activarsaldo_mone_extraSaldoContable;
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
		
		
		this.setMostraridSaldoContable(esInicial);
		this.setMostrarid_empresaSaldoContable(esInicial);
		this.setMostrarid_sucursalSaldoContable(esInicial);
		this.setMostrarid_ejercicioSaldoContable(esInicial);
		this.setMostrarid_periodoSaldoContable(esInicial);
		this.setMostrarid_anioSaldoContable(esInicial);
		this.setMostrarid_mesSaldoContable(esInicial);
		this.setMostrarid_cuenta_contableSaldoContable(esInicial);
		this.setMostrardebito_mone_localSaldoContable(esInicial);
		this.setMostrarcredito_mone_localSaldoContable(esInicial);
		this.setMostrarsaldo_mone_localSaldoContable(esInicial);
		this.setMostrardebito_mone_extraSaldoContable(esInicial);
		this.setMostrarcredito_mone_extraSaldoContable(esInicial);
		this.setMostrarsaldo_mone_extraSaldoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoContableConstantesFunciones.ID)) {
				this.setMostraridSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDMES)) {
				this.setMostrarid_mesSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONELOCAL)) {
				this.setMostrarsaldo_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONEEXTRA)) {
				this.setMostrarsaldo_mone_extraSaldoContable(esAsigna);
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
		
		
		this.setActivaridSaldoContable(esInicial);
		this.setActivarid_empresaSaldoContable(esInicial);
		this.setActivarid_sucursalSaldoContable(esInicial);
		this.setActivarid_ejercicioSaldoContable(esInicial);
		this.setActivarid_periodoSaldoContable(esInicial);
		this.setActivarid_anioSaldoContable(esInicial);
		this.setActivarid_mesSaldoContable(esInicial);
		this.setActivarid_cuenta_contableSaldoContable(esInicial);
		this.setActivardebito_mone_localSaldoContable(esInicial);
		this.setActivarcredito_mone_localSaldoContable(esInicial);
		this.setActivarsaldo_mone_localSaldoContable(esInicial);
		this.setActivardebito_mone_extraSaldoContable(esInicial);
		this.setActivarcredito_mone_extraSaldoContable(esInicial);
		this.setActivarsaldo_mone_extraSaldoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoContableConstantesFunciones.ID)) {
				this.setActivaridSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDANIO)) {
				this.setActivarid_anioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDMES)) {
				this.setActivarid_mesSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONELOCAL)) {
				this.setActivarsaldo_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONEEXTRA)) {
				this.setActivarsaldo_mone_extraSaldoContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSaldoContable(esInicial);
		this.setResaltarid_empresaSaldoContable(esInicial);
		this.setResaltarid_sucursalSaldoContable(esInicial);
		this.setResaltarid_ejercicioSaldoContable(esInicial);
		this.setResaltarid_periodoSaldoContable(esInicial);
		this.setResaltarid_anioSaldoContable(esInicial);
		this.setResaltarid_mesSaldoContable(esInicial);
		this.setResaltarid_cuenta_contableSaldoContable(esInicial);
		this.setResaltardebito_mone_localSaldoContable(esInicial);
		this.setResaltarcredito_mone_localSaldoContable(esInicial);
		this.setResaltarsaldo_mone_localSaldoContable(esInicial);
		this.setResaltardebito_mone_extraSaldoContable(esInicial);
		this.setResaltarcredito_mone_extraSaldoContable(esInicial);
		this.setResaltarsaldo_mone_extraSaldoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldoContableConstantesFunciones.ID)) {
				this.setResaltaridSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDMES)) {
				this.setResaltarid_mesSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONELOCAL)) {
				this.setResaltarsaldo_mone_localSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraSaldoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldoContableConstantesFunciones.SALDOMONEEXTRA)) {
				this.setResaltarsaldo_mone_extraSaldoContable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableSaldoContable=true;

	public Boolean getMostrarFK_IdCuentaContableSaldoContable() {
		return this.mostrarFK_IdCuentaContableSaldoContable;
	}

	public void setMostrarFK_IdCuentaContableSaldoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableSaldoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioSaldoContable=true;

	public Boolean getMostrarFK_IdEjercicioSaldoContable() {
		return this.mostrarFK_IdEjercicioSaldoContable;
	}

	public void setMostrarFK_IdEjercicioSaldoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioSaldoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSaldoContable=true;

	public Boolean getMostrarFK_IdEmpresaSaldoContable() {
		return this.mostrarFK_IdEmpresaSaldoContable;
	}

	public void setMostrarFK_IdEmpresaSaldoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSaldoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoSaldoContable=true;

	public Boolean getMostrarFK_IdPeriodoSaldoContable() {
		return this.mostrarFK_IdPeriodoSaldoContable;
	}

	public void setMostrarFK_IdPeriodoSaldoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoSaldoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSaldoContable=true;

	public Boolean getMostrarFK_IdSucursalSaldoContable() {
		return this.mostrarFK_IdSucursalSaldoContable;
	}

	public void setMostrarFK_IdSucursalSaldoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSaldoContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableSaldoContable=true;

	public Boolean getActivarFK_IdCuentaContableSaldoContable() {
		return this.activarFK_IdCuentaContableSaldoContable;
	}

	public void setActivarFK_IdCuentaContableSaldoContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableSaldoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioSaldoContable=true;

	public Boolean getActivarFK_IdEjercicioSaldoContable() {
		return this.activarFK_IdEjercicioSaldoContable;
	}

	public void setActivarFK_IdEjercicioSaldoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioSaldoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSaldoContable=true;

	public Boolean getActivarFK_IdEmpresaSaldoContable() {
		return this.activarFK_IdEmpresaSaldoContable;
	}

	public void setActivarFK_IdEmpresaSaldoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSaldoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoSaldoContable=true;

	public Boolean getActivarFK_IdPeriodoSaldoContable() {
		return this.activarFK_IdPeriodoSaldoContable;
	}

	public void setActivarFK_IdPeriodoSaldoContable(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoSaldoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSaldoContable=true;

	public Boolean getActivarFK_IdSucursalSaldoContable() {
		return this.activarFK_IdSucursalSaldoContable;
	}

	public void setActivarFK_IdSucursalSaldoContable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSaldoContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableSaldoContable=null;

	public Border getResaltarFK_IdCuentaContableSaldoContable() {
		return this.resaltarFK_IdCuentaContableSaldoContable;
	}

	public void setResaltarFK_IdCuentaContableSaldoContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableSaldoContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableSaldoContable= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioSaldoContable=null;

	public Border getResaltarFK_IdEjercicioSaldoContable() {
		return this.resaltarFK_IdEjercicioSaldoContable;
	}

	public void setResaltarFK_IdEjercicioSaldoContable(Border borderResaltar) {
		this.resaltarFK_IdEjercicioSaldoContable= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioSaldoContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSaldoContable=null;

	public Border getResaltarFK_IdEmpresaSaldoContable() {
		return this.resaltarFK_IdEmpresaSaldoContable;
	}

	public void setResaltarFK_IdEmpresaSaldoContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSaldoContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSaldoContable= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoSaldoContable=null;

	public Border getResaltarFK_IdPeriodoSaldoContable() {
		return this.resaltarFK_IdPeriodoSaldoContable;
	}

	public void setResaltarFK_IdPeriodoSaldoContable(Border borderResaltar) {
		this.resaltarFK_IdPeriodoSaldoContable= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoSaldoContable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSaldoContable=null;

	public Border getResaltarFK_IdSucursalSaldoContable() {
		return this.resaltarFK_IdSucursalSaldoContable;
	}

	public void setResaltarFK_IdSucursalSaldoContable(Border borderResaltar) {
		this.resaltarFK_IdSucursalSaldoContable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSaldoContable(ParametroGeneralUsuario parametroGeneralUsuario/*SaldoContableBeanSwingJInternalFrame saldocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSaldoContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}